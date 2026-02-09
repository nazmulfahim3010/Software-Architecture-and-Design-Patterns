public class Interface_Segragation {
    public static void main(String[] args) {
        Printer printer = new SimplePrinter();
        printer.print();

        AllInOnePrinter aio = new AllInOnePrinter();
        aio.print();
        aio.scan();
    }
}

interface Printer {
    void print();
}

interface Scanner {
    void scan();
}

class SimplePrinter implements Printer {
    public void print() {
        System.out.println("Printing document...");
    }
}

class AllInOnePrinter implements Printer, Scanner {
    public void print() {
        System.out.println("Printing document...");
    }

    public void scan() {
        System.out.println("Scanning document...");
    }
}
