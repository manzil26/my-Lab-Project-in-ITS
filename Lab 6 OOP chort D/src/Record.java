public class Record {
    private String name;
    private String date;
    private int amountOwed;
    private int amountPayed;

    public Record(String name, String date, int amountOwed, int amountPayed){
        this.name = name;
        this.date = date;
        this.amountOwed = amountOwed;
        this.amountPayed = amountPayed;
    }

    public String getName(){
        return name;
    }

    public String getDate(){
        return date;
    }

    public int getAmountOwed(){
        return amountOwed;
    }

    public int getAmountPayed(){
        return amountPayed;
    }

    public int getChange(){
        return Math.abs( amountPayed-amountOwed);
    }
}