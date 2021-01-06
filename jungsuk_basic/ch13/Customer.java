package ch13;

class Customer implements Runnable{
    private Table table;
    private String food;

    Customer (Table table, String food) {
        this.table = table;
        this.food = food;
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(100);
            }catch (InterruptedException e) {}

            String name = Thread.currentThread().getName();

            table.remove(food);
            System.out.println(name+ " ate a "+food);

        }
    }

}
