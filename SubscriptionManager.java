import java.util.ArrayList;

public class SubscriptionManager {
    private ArrayList<Customer> customers;
    private ArrayList<Service> services;
    private ArrayList<Subscription> subscriptions;

    public SubscriptionManager() {
        this.customers = new ArrayList<>();
        this.services = new ArrayList<>();
        this.subscriptions = new ArrayList<>();
    }
    public SubscriptionManager(ArrayList<Customer> customers, ArrayList<Service> services, ArrayList<Subscription> subscriptions) {
        this.customers = new ArrayList<>(customers);
        this.services = new ArrayList<>(services);
        this.subscriptions = new ArrayList<>(subscriptions);
    }

    public ArrayList<Customer> getCustomers() {
        return new ArrayList<>(customers);
    }
    public ArrayList<Service> getServices() {
        return new ArrayList<>(services);
    }
    public ArrayList<Subscription> getSubscriptions() {
        return new ArrayList<>(subscriptions);
    }
    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = new ArrayList<>(customers);
    }
    public void setServices(ArrayList<Service> services) {
        this.services = new ArrayList<>(services);
    }
    public void setSubscriptions(ArrayList<Subscription> subscriptions) {
        this.subscriptions = new ArrayList<>(subscriptions);
    }

    @Override
    public String toString() {
        return "Customers: " + customers + "\nServices: " + services + "\nSubscriptions: " + subscriptions + "\n";
    }

    public void addCustomer(String name, String email) {
        int nextId = customers.stream()
                             .mapToInt(Customer::getId)
                             .max()
                             .orElse(0) + 1;
        customers.add(new Customer(nextId, name, email));
    }
    public void addService(String name, String description) {
        services.add(new Service(name, description));
    }
}