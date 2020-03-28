package performer;

import utils.XmlForSave;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Performer implements Runnable {

    @Override
    public /*synchronized*/ void run() {
        try {
            LocalDateTime localDateTime = LocalDateTime.now();
            String formattedTime = localDateTime.format(DateTimeFormatter.ofPattern("dd-MM-YYYY hh-mm-ss"));
            XmlForSave xmlForSave = new XmlForSave();
            xmlForSave.saveXmlFile("TestFileName " + Thread.currentThread().getName() + " " + formattedTime,"1", Thread.currentThread().getName());
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //notify();
    }

}
