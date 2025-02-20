import java.util.*;

class Policy {
    int policyNumber;
    String policyHolderName;
    int expiryDate;
    String coverage;
    int premiumAmount;

    public Policy(int policyNumber, String policyHolderName, int expiryDate, String coverage, int premiumAmount) {
        this.policyNumber = policyNumber;
        this.policyHolderName = policyHolderName;
        this.expiryDate = expiryDate;
        this.coverage = coverage;
        this.premiumAmount = premiumAmount;
    }

    public void display() {
        System.out.println("Policy Number: " + policyNumber);
        System.out.println("Policy Holder Name: " + policyHolderName);
        System.out.println("Policy Expiry Date: " + expiryDate);
        System.out.println("Policy Coverage: " + coverage);
        System.out.println("Policy Premium Amount: " + premiumAmount);
        System.out.println();
    }
}

class InsuranceManagementSystem {
    Set<Policy> hs;
    LinkedHashSet<Policy> ls;
    TreeSet<Policy> ts;

    public InsuranceManagementSystem() {
        this.hs = new HashSet<>();
        this.ls = new LinkedHashSet<>();
        this.ts = new TreeSet<>(Comparator.comparingInt(p -> p.expiryDate));
    }

    public void add(Policy p) {
        for (Policy po : hs) {
            if (p.policyNumber == po.policyNumber && !p.policyHolderName.equals(po.policyHolderName)) {
                System.out.println("Cannot add another user with the same policy number");
                return;
            }
        }
        hs.add(p);
        ls.add(p);
        ts.add(p);
    }

    public void retrieveAllUnique() {
        for (Policy p : ls) {
            p.display();
        }
    }

    public void expiring() {
        for (Policy p : hs) {
            if (p.expiryDate <= 30) {
                p.display();
            }
        }
    }

    public void coverageType(String type) {
        for (Policy p : hs) {
            if (p.coverage.equals(type)) {
                p.display();
            }
        }
    }

    public void duplicatePolicy(int policyNumber) {
        for (Policy p : hs) {
            if (p.policyNumber == policyNumber) {
                p.display();
            }
        }
    }

    public void remove(Policy p) {
        ls.remove(p);
        hs.remove(p);
        ts.remove(p);
    }
}

public class Main {
    public static void main(String[] args) {
        Policy p1 = new Policy(1, "Aman", 50, "Health", 6);
        Policy p2 = new Policy(1, "Akshat", 20, "Auto", 6);
        Policy p3 = new Policy(2, "Aryan", 50, "Health", 6);
        Policy p4 = new Policy(3, "Anshul", 50, "Medicine", 6);

        InsuranceManagementSystem ims = new InsuranceManagementSystem();
        ims.add(p1);
        ims.add(p2);
        ims.add(p3);
        ims.add(p4);

        System.out.println("Coverage:");
        ims.coverageType("Health");

        System.out.println("Expiring in 30 days:");
        ims.expiring();

        System.out.println("All unique policies:");
        ims.retrieveAllUnique();

        System.out.println("Duplicate policies:");
        ims.duplicatePolicy(1);
    }
}