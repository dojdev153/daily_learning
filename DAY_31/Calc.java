/*class Boy implements Runnable {
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("boy");
            try { Thread.sleep(1000); } catch (Exception e) {}
        }
    }
}

class Girl implements Runnable {
    public void run() {
        for (int i = 0; i < 7; i++) {
            System.out.println("girl");
            try { Thread.sleep(1000); } catch (Exception e) {}
        }
    }
}
*/
public class Calc {
    public static void main(String[] args) {
        Thread boy = new Thread(() -> {
            for(int i=0; i < 20; i++){
                System.out.println("boy");
                try { 
                    Thread.sleep(1000); 
                } catch (Exception e) {}
            }
        });

        Thread girl = new Thread(() -> {
            for(int i=0; i< 7; i++){
                System.out.println("girl");
                try { 
                    Thread.sleep(1000); 
                } catch (Exception e) {}
            }
        });

        boy.start();
        girl.start();
    }
}
