abstract class paymentGateway{
    abstract void payment(double amount);
}
class payPal extends paymentGateway{
    @Override
    void payment(double amount){
        System.out.println("paid $" + amount + " using payPal");
    }
}
class MasterCard extends paymentGateway{
    @Override
    void payment(double amount){
        System.out.println("paid $" + amount + " using MasterCard");
    }
}
class Momo extends paymentGateway{
    @Override
    void payment(double amount){
        System.out.println("paid $" + amount + " using Momo");
    }
}

class paymentProcessor{
    private paymentGateway gateway;
    paymentProcessor(paymentGateway gateway){
        this.gateway = gateway;
    }
    void processPayment(double amount){
        gateway.payment(amount);
    }
}

public class Abstraction{
    public static void main(String[] a){
        paymentProcessor p1 = new paymentProcessor(new payPal());
        p1.processPayment(100.0);
        paymentProcessor p2 = new paymentProcessor(new MasterCard());
        p2.processPayment(100.0);
        paymentProcessor p3 = new paymentProcessor(new Momo());
        p3.processPayment(100.0);
    }
}