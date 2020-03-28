import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

public class main {

    public static void main (String [] args) {
        //ExecutorService executorService = Executors.newFixedThreadPool(10);
        Performer performer = new Performer();
        performer.start();
        System.out.println(Thread.currentThread().getName());
    }


}
