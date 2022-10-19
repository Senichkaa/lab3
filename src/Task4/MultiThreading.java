package Task4;

class MultiThreading implements Runnable
{

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("calculating " + Thread.currentThread().getName());
                Thread.sleep(100);
            }
        } catch (final InterruptedException e) {

        }

    }
}

