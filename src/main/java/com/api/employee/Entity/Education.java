package com.api.employee.Entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

public class Education {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String type;
    private Date startdate;
    private Date endDate;
    private String Institution;
    private String address;
    private String precentage;

    /**
     * 
     */
    public Education() {
    }

    /**
     * @param id
     * @param type
     * @param startdate
     * @param endDate
     * @param institution
     * @param address
     * @param precentage
     */
    public Education(int id, String type, Date startdate, Date endDate, String institution, String address,
            String precentage) {
        this.id = id;
        this.type = type;
        this.startdate = startdate;
        this.endDate = endDate;
        Institution = institution;
        this.address = address;
        this.precentage = precentage;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the startdate
     */
    public Date getStartdate() {
        return startdate;
    }

    /**
     * @param startdate the startdate to set
     */
    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the institution
     */
    public String getInstitution() {
        return Institution;
    }

    /**
     * @param institution the institution to set
     */
    public void setInstitution(String institution) {
        Institution = institution;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the precentage
     */
    public String getPrecentage() {
        return precentage;
    }

    /**
     * @param precentage the precentage to set
     */
    public void setPrecentage(String precentage) {
        this.precentage = precentage;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "Education [Institution=" + Institution + ", address=" + address + ", endDate=" + endDate + ", id=" + id
                + ", precentage=" + precentage + ", startdate=" + startdate + ", type=" + type + "]";
    }

}
