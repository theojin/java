public class ThreadA extends Thread {
    ThreadSharedMemory sm;

    ThreadA(ThreadSharedMemory sm) {
        this.sm = sm;
    }

    public synchronized void set() {
        sm.obj = "Something important";
        sm.isReady = true;
    }

    public void run() {
        set();
        synchronized (sm) {
            sm.notifyAll();
        }
    }
}
