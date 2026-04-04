package BillPughSingletonPattern;

/**
 * It is a Singleton.
 * The Bill Pugh Singleton - The "Gold Standard"
 * This method is both Lazy and Thread-Safe without the overhead of synchronization.
 */
public class Cde {
    
    // 1. Private constructor ensures no one else can create an instance.
    private Cde() {
        System.out.println("Cde Instance Created via Bill Pugh Method!!!");
    }
    
    
    /**
     * 2. The Static Inner Helper Class.
     * This class is NOT loaded into memory when ABC is loaded.
     * It is only loaded when someone calls getInstance() for the first time.
     * The JVM handles thread safety during class loading automatically.
     */
    private static class SingletonHelper {
        // This is the single, final instance of the parent class.
        private static final Cde INSTANCE = new Cde();
    }
    
    
    /**
     * 3. Global Access Point.
     * When this is called, it triggers the loading of SingletonHelper.
     * Since class loading is atomic and serial, no two threads can create
     * two different instances.
     * * @return The unique instance of Cde.
     */
    public static Cde getInstance() {
        return SingletonHelper.INSTANCE;
    }
    
    
    public void doWork() {
        System.out.println("Singleton is running efficiently...");
    }
}
