package ch13;

class Ex13_11 {
    static long startTime = 0;

    public static void main(String[] args) {
        ThreadEx11_1 th1 = new ThreadEx11_1();
        ThreadEx11_2 th2 = new ThreadEx11_2();

        th1.start();
        th2.start();
        startTime = System.currentTimeMillis();

        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {

        }

        System.out.println("Running Time : "+(System.currentTimeMillis() - startTime));
    }
}

class ThreadEx11_1 extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 300 ; i++ ){
            System.out.println(new String("-"));
        }
    }
}
class ThreadEx11_2 extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 300 ; i++ ){
            System.out.println(new String("|"));
        }
    }
}