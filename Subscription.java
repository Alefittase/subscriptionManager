
import java.util.Date;

public class Subscription {
    private Customer customer;
    private Service service;
    private Date startDate;
    private boolean state;
    //constructor
    public Subscription() {
        startDate = Date.from(null);
        state = true;
    }
    public Subscription(Customer customer, Service service, Date startDate, boolean state) {
        this.customer = customer;
        this.service = service;
        this.startDate = startDate;
        this.state = state;
    }
    public Subscription(Customer customer, Service service) {
        this.customer = customer;
        this.service = service;
        startDate = Date.from(null);
        state = true;
    }
    //setter-getter methods
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public void setService(Service service) {
        this.service = service;
    }
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    public void setState(boolean state) {
        this.state = state;
    }
    public Customer getCustomer() {
        return customer;
    }
    public Service getService() {
        return service;
    }
    public Date getStartDate() {
        return startDate;
    }
    public boolean getState() {
        return state;
    }

    @Override
    public String toString() {
        return "Customer: " + customer.getName() + "\nService: " + service.getName() + "\nStart date: " + startDate.toString() + "\nState: " + (state ? "Active" : "Inactive");
    }
}