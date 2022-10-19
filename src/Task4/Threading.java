package Task4;

class Threading extends Thread {

    Threading() {
        super("Threading Thread Class");
    }

    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("calculating " + this);
                Thread.sleep(100);
            }
        } catch (final InterruptedException e) {

        }

    }

}

