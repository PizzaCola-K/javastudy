package ch13;

class Exercise13_1 {
    public static void main(String[] args) {
        Thread th1 = new Thread(new Runnable1());
        th1.start();
    }
}

class Runnable1 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.print("-");
        }
    }
}
