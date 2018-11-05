package dk.tdc.simulation;

import dk.tdc.model.Advisor;
import dk.tdc.model.Customer;
import dk.tdc.model.Holdings;

public class Simulation {
    private Customer customer;
    private Advisor advisor;
    private Holdings holdings;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Advisor getAdvisor() {
        return advisor;
    }

    public void setAdvisor(Advisor advisor) {
        this.advisor = advisor;
    }

    public Holdings getHoldings() {
        return holdings;
    }

    public void setHoldings(Holdings holdings) {
        this.holdings = holdings;
    }
}
