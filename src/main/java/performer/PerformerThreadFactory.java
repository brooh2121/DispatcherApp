package performer;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class PerformerThreadFactory implements ThreadFactory {

    private AtomicInteger counter = new AtomicInteger(1);

    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new  Thread(r);
       thread.setName(String.valueOf(counter.getAndIncrement()));
        return thread;
    }
}
