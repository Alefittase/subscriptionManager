import java.util.ArrayList;
import java.util.stream.Collectors;

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

    public void addSubscription(Customer customer, Service service) {
        Customer managedCustomer = customers.stream()
                                          .filter(c -> c.equals(customer))
                                          .findFirst()
                                          .orElse(null);        
        Service managedService = services.stream()
                                       .filter(s -> s.equals(service))
                                       .findFirst()
                                       .orElse(null);
        
        if (managedCustomer != null && managedService != null) {
            boolean exists = subscriptions.stream().anyMatch(sub -> 
                sub.getCustomer().equals(managedCustomer) && 
                sub.getService().equals(managedService));            
            if (!exists) {
                Subscription sub = new Subscription();
                sub.setCustomer(managedCustomer);
                sub.setService(managedService);
                sub.setState(true);
                subscriptions.add(sub);
            }
        }
    }

    public void deactiveSubscription(Subscription sub) {
        subscriptions.stream()
            .filter(s -> s.equals(sub))
            .findFirst()
            .ifPresent(s -> s.setState(false));
    }

    public ArrayList<Subscription> getActiveSubscriptions() {
        return subscriptions.stream()
                            .filter(Subscription::getState)
                            .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<Subscription> getActiveSubscriptions(Customer customer) {
        return subscriptions.stream()
                            .filter(sub -> 
                                sub.getState() && 
                                sub.getCustomer().equals(customer))
                            .collect(Collectors.toCollection(ArrayList::new));
    }
}