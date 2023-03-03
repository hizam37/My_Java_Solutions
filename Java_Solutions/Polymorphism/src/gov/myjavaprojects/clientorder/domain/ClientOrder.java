package gov.myjavaprojects.clientorder.domain;


import gov.myjavaprojects.clientorder.domain.other.Adult;

public class ClientOrder {
    private long clientorderid;
    private Adult huzband;
    private Adult wife;
    private Child child;

    public long getClientorderid() {
        return clientorderid;
    }

    public void setClientorderid(long clientorderid) {
        this.clientorderid = clientorderid;
    }

    public Adult getHuzband() {
        return huzband;
    }

    public void setHuzband(Adult huzband) {
        this.huzband = huzband;
    }

    public Adult getWife() {
        return wife;
    }

    public void setWife(Adult wife) {
        this.wife = wife;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }
}


