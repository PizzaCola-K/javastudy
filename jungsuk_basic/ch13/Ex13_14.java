package ch13;

class Ex13_14 {
    public static void main(String[] args) throws Exception{
        Table table = new Table();

        new Thread(new Cook(table),"COOK").start();
        new Thread(new Customer(table, "donut"),"CUST1").start();
        new Thread(new Customer(table, "burger"),"CUST2").start();

        Thread.sleep(5000);
        System.exit(0);
    }
}
