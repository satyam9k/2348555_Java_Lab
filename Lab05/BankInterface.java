package Lab05;
public interface BankInterface {

    double getBalance();

    double getInterestRate();
}

class BankA implements BankInterface {

    private final double balance = 10000; // Initial balance for Bank A

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double getInterestRate() {
        return 7.0;
    }
}

class BankB implements BankInterface {

    private final double balance = 150000; // Initial balance for Bank B

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double getInterestRate() {
        return 7.4;
    }
}

class BankC implements BankInterface {

    private final double balance = 200000; // Initial balance for Bank C

    @Override
    public double getBalance() {
        return balance;
    }

    @Override
    public double getInterestRate() {
        return 7.9;
    }
}

class Main {

    public static void main(String[] args) {

        // Create bank instances with pre-defined initial balances
        BankInterface bankA = new BankA();
        BankInterface bankB = new BankB();
        BankInterface bankC = new BankC();

        // Print information for each bank
        System.out.println("Bank A");
        System.out.println("Balance:" + bankA.getBalance());
        System.out.println("Interest Rate: " + bankA.getInterestRate() + "%");
        System.out.println();

        System.out.println("Bank B");
        System.out.println("Balance:" + bankB.getBalance());
        System.out.println("Interest Rate: " + bankB.getInterestRate() + "%");
        System.out.println();

        System.out.println("Bank C");
        System.out.println("Balance:" + bankC.getBalance());
        System.out.println("Interest Rate: " + bankC.getInterestRate() + "%");
    }
}
