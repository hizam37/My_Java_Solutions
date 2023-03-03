package gov.myjavaprojects.clientorder.domain;

public class CityRegisterCheckerRespone {
    private boolean existing;
    private Boolean temporal=null;

    public boolean isExisting() {
        return existing;
    }

    public void setExisting(boolean existing) {
        this.existing = existing;
    }

    public Boolean getTemporal() {
        return temporal;
    }

    public void setTemporal(Boolean temporal) {
        this.temporal = temporal;
    }
}
