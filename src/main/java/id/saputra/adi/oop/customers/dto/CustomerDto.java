package id.saputra.adi.oop.customers.dto;

import java.io.Serializable;

public class CustomerDto implements Serializable {
    private String cif;
    private String name;
    private String mobilePhone;

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
}
