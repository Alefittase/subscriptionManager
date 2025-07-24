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
    
}