public class ThreadB implements Runnable {
    ThreadSharedMemory sm;

    ThreadB(ThreadSharedMemory sm) {
        this.sm = sm;
    }

    public void run() {
        while (!sm.isReady) {
            try {
                synchronized (sm) {
                    sm.wait();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            continue;
        }
    }
}
