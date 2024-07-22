public class Pos {
    private Record[] records; // deklarasi record array
    private int recordCount; // menghitung records untuk indexing di record objects di array

    public Pos() {

        records = new Record[4]; //membuat array utuk menyimpan record array. atur ukuranya 4 karena ada 4 baris data dari input file

        recordCount = 0; //  insialiasi record count = 0
    }

    public void add(String name, String date, String amountOwedStr, String amountPaidStr) {
        try {
            int amountOwed = Integer.parseInt(amountOwedStr); // mengubah dari string ke int
            int amountPaid = Integer.parseInt(amountPaidStr); // mengubah dari string ke int




            // buat sebuah record objek baru dengan provided data
            Record record = new Record(name, date, amountOwed, amountPaid);

            // Tambahkan record objek ke record array
            records[recordCount++] = record;
        } catch (Exception e) {
            System.out.println("Cannot convert String to Integer for name " + name + " Because: For input string: " + amountPaidStr);
        }
    }

    public void change(int amount, int[] denominations, int index) {
        //base case untu rekursi: jika jumlahnya 0 atau tidak lebih dari denominasi
        if (amount == 0 || index == denominations.length) {
            return;
        }

        int denomination = denominations[index];
        int quantity = amount / denomination;

        if (quantity > 0) {
            System.out.println(denomination + "\t\t|\t  " + quantity);
            amount %= denomination;
        }

        //memanggil rekusrsi dengan mengupdate amount dan index selanjutnya
        change(amount, denominations, index + 1);
    }


    // Method untuk mendapatkan number of records
    public int getLength() {
        return recordCount;
    }

    // method untuk mendapatkan spesifik record dengan index
    public Record getRecord(int index) {
        if (index >= 0 && index < recordCount) {
            return records[index];
        } else {
            throw new IndexOutOfBoundsException("Index out of bounds for the records array.");
        }
    }


}