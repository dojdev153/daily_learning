public interface Calc {
    int add(int a, int b);
}

class PlanBoy extends Thread {
    public void run() {
        sittingPlan();
    }

    public void sittingPlan() {
        for (int i = 0; i < 20; i++) {
            System.out.println("boy");
            try {
                Thread.sleep(1000); // sleep 1 second
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class PlanGirl extends Thread {
    public void run() {
        sittingPlan();
    }

    public void sittingPlan() {
        for (int i = 0; i < 7; i++) {
            System.out.println("girl");
            try {
                Thread.sleep(1000); // sleep 1 second
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

public class CalcMain {
    public static void main(String[] args) {
        PlanBoy pb = new PlanBoy();
        pb.start();   // starts boy thread

        PlanGirl pg = new PlanGirl();
        pg.start();   // starts girl thread
    }
}
