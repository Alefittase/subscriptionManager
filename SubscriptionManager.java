import java.util.ArrayList;

public class SubscriptionManager {
    private ArrayList<Customer> customers;
    private ArrayList<Service> services;
    private ArrayList<Subscription> subscriptions;
    //constructor
    public SubscriptionManager() {
    }
    public SubscriptionManager(ArrayList<Customer> customers, ArrayList<Service> services, ArrayList<Subscription> subscriptions) {
        this.customers = customers;
        this.services = services;
        this.subscriptions = subscriptions;
    }
    //setter-getter methods
    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }
    public void setServices(ArrayList<Service> services) {
        this.services = services;
    }
    public void setSubscriptions(ArrayList<Subscription> subscriptions) {
        this.subscriptions = subscriptions;
    }
    public ArrayList<Customer> getCustomers() {
        ArrayList<Customer> customersOUT = customers;
        return customersOUT;
    }
    public ArrayList<Service> getServices() {
        ArrayList<Service> servicesOUT = services;
        return servicesOUT;
    }
    public ArrayList<Subscription> getSubscriptions() {
        ArrayList<Subscription> subscriptionsOUT = subscriptions;
        return subscriptionsOUT;
    }

    @Override
    public String toString() {
        return "Customers: " + customers.toString() + "\nServices: " + services.toString() + "\nsubscriptions: " + subscriptions.toString() + "\n";
    }
    
    public void addCustomer(String name, String email){
        int id;
        if(customers.isEmpty()) id = 1;
        else id = customers.getLast().getId()+1;
        Customer c = new Customer(id, name, email);
        customers.add(c);
    }
    public void addService(String name, String description) {
        Service s = new Service(name, description);
        services.add(s);
    }
    public void addSubscription(Customer customer, Service service){
        Subscription sub = new Subscription();
        boolean fc=false, fs=false;
        for(Customer c:customers){
            if(c.equals(customer)){
                sub.setCustomer(c);
                fc=true;
            }
        }
        for(Service s:services){
            if(s.equals(service)){
                sub.setService(s);
                fs=true;
            }
        }
        if(fc && fs){
            subscriptions.add(sub);
        }
    }


}