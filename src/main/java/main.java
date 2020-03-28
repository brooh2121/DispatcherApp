import org.omg.CORBA.Environment;
import performer.PerformerThreadFactory;
import performer.Performer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class main {

    public static void main (String [] args) {


        PerformerThreadFactory performerThreadFactory = new PerformerThreadFactory();
        Performer performer = new Performer();
        ExecutorService executorService = Executors.newFixedThreadPool(5,performerThreadFactory);
        for (int i = 0; i < 200; i++) {
            executorService.execute(performer);
        }
        executorService.shutdown();
    }


}
