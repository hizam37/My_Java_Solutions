package gov.myjavaprojects.clientorder.domain;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClientOrder {
    private long clientorderid;
    private Adult huzband;
    private Adult wife;
    private List<Child> children;

    private String merriageCertificateId;
    private String merriageOffice;
    private LocalDate marriageDate;

    public String getMerriageCertificateId() {
        return merriageCertificateId;
    }

    public void setMerriageCertificateId(String merriageCertificate) {
        this.merriageCertificateId = merriageCertificate;
    }

    public String getMerriageOffice() {
        return merriageOffice;
    }

    public void setMerriageOffice(String merriageOffice) {
        this.merriageOffice = merriageOffice;
    }

    public LocalDate getMarriageDate() {
        return marriageDate;
    }

    public void setMarriageDate(LocalDate marriageDate) {
        this.marriageDate = marriageDate;
    }

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

    public List<Child> getChildren() {
        return children;
    }

    public void addChild(Child child)
    {
        if(children==null)
        {
            children = new ArrayList<>(5);
        }
        children.add(child);
    }
}



