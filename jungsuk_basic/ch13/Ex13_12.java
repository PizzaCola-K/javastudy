package ch13;

class Ex13_12 {
    public static void main(String[] args) {
        Runnable r = new RunnableEx12();
        new Thread(r).start();
        new Thread(r).start();
    }
}

class RunnableEx12 implements Runnable {
    Account acc = new Account();
    @Override
    public void run() {
        while(acc.getBalance() > 0) {
            int money = (int) (Math.random() * 3 + 1)*100;
            acc.withdraw(money);
            System.out.println("balance:"+acc.getBalance());
        }
    }
}