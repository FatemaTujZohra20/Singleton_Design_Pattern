package BillPughSingletonPattern;

// The client code remains identical, proving that the Singleton pattern provides a consistent interface
// regardless of the internal "plumbing."
/**
 * Main Entry Point.
 */
public class BillPughSingleton {
    public static void main (String[] args) {
        
        System.out.println(" ---- App Started ---- ");
        
        // Notice: "Cde Instance created..." will not print until this line runs.
        Cde obj1 = Cde.getInstance();
        Cde obj2 = Cde.getInstance();
        
        // --- Verification Logic -----
        if (obj1 == obj2) {
            System.out.println("Verification: Identical instances found...");
        }
        
        System.out.println("Instance Hash: " + obj1.hashCode());
        obj1.doWork();
    }
}
