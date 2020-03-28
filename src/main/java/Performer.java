public class Performer extends Thread {

    @Override
    public synchronized void run() {
        int i = 1;
        Thread.currentThread().setName("Performer" + i);
        System.out.println(Thread.currentThread().getName()+ " " + "Hello from side Thread");
        try {
            for(int j = 0; j < 10; j ++) {
                XmlForSave xmlForSave = new XmlForSave();
                xmlForSave.saveXmlFile("TestFile" + j, String.valueOf(i),String.valueOf(j + 1));
                sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+ " " + "works and");
        notify();
    }

}
