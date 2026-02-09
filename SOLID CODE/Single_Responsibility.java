
class Order {
    public void addorder() {
        System.out.println("hello order");
    }

    public void calculateTotal() {
        System.out.println("price claculated");
    }
}

class Invoice {
    public void printInvoice() {
        System.out.println("invoice printed");
    }
}

class sendEmail {
    public void sendEmailinvoive() {
        System.out.println("send invoice email");
    }
}

public class Single_Responsibility {
    public static void main(String[] args) {
        // Single_Responsibility t = new Single_Responsibility();

        Order order = new Order();
        order.addorder();
        order.calculateTotal();
        Invoice in = new Invoice();
        in.printInvoice();
        sendEmail SE = new sendEmail();
        SE.sendEmailinvoive();

    }

}
