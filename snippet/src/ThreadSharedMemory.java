public class ThreadSharedMemory {
    Object obj;
    volatile boolean isReady = false;

    ThreadSharedMemory(Object obj) {
        this.obj = obj;
    }
}
