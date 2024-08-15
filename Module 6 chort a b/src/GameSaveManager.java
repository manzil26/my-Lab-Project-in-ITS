import java.io.*; // mengimpor semua kelas dalam paket java

public class GameSaveManager {
    // nama file tempat game state akan disimpan
    private static final String FILE_NAME = "src/gameSave.txt";
    // metode untuk menyimpan keadaan permainan ke file
    public static void saveGameState(GameState gameState) {
        // menggunakan buffer reader untuk menulis data
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            // menulis nama player ke file gameSave.txt
            writer.write(gameState.getPlayer().getName() + "\n");
            // menulis nyawa player ke file gameSave.txt
            writer.write(gameState.getPlayer().getHealth() + "\n");
            // menulis level player ke file gameSave.txt
            writer.write(gameState.getCurrentLevel() + "\n");
        //menyimpan inventaris pemain ke dalam bentuk string
            String[] inventory = gameState.getInventory();
            // menulis setiap inventory ke item
            for (String item : inventory) {
                // jika item tidak sama dengan null
                if (item != null) {
                    // maka tulis item ke dalam file
                    writer.write(item + "\n");
                }
            }
            // game tersimpan
            System.out.println("Game saved");
        } catch (IOException e) {
            // memunculkan pesan ke salahan ketika saat menyimpan game satate
            System.out.println("Error saving game state: " + e.getMessage());
        }

    }
   // metode untuk memuat keadaan permainan dari file atau menampilkan data ke user ketika use memanggil datanya
    public static GameState loadGameState() {
        // menggunakan buffer reader untuk membaca data dari file
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            // membaca nama dari file
            String name = reader.readLine();
            // membaca nyawa dari file
            int health = Integer.parseInt(reader.readLine());
            // membaca level
            int level = Integer.parseInt(reader.readLine());

            // Inisialisasi array inventaris dengan ukuran tetap yang cukup besar
            String[] inventory = new String[100]; // Menyesuaikan ukuran jika diperlukan
            int index = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                if (index < inventory.length) {
                    inventory[index++] = line;
                }
            }

            // Mengubah array inventaris menjadi ukuran yang tepat
            String[] finalInventory = new String[index];
            System.arraycopy(inventory, 0, finalInventory, 0, index);

            Player player = new Player(name, health);
            return new GameState(player, finalInventory, level);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading game state: " + e.getMessage());
            return null;
        }
    }

    public static int countItems(GameState gameState) {
        int count = 0;
        String[] inventory = gameState.getInventory();
        for (String item : inventory) {
            if (item != null) {
                String[] nestedItems = item.split(",");
                count += nestedItems.length;
            }
        }
        return count;
    }
}



