package com.api.employee.Entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity

public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String firstName;
    private String lastName;
    private String employmentId;
    private Date startDate;
    private String designation;
    private String department;
    private Date endDate;
    private String status;
    private Date dob;
    private String reporting_Manager;
    private String gender;
    private String blood_Group;
    private String address;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Dependent> dependent;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Education> education;

    /**
     * 
     */
    public Employee() {
    }

    /**
     * @param id
     * @param firstName
     * @param lastName
     * @param employmentId
     * @param startDate
     * @param designation
     * @param department
     * @param endDate
     * @param status
     * @param dob
     * @param reporting_Manager
     * @param gender
     * @param blood_Group
     * @param address
     * @param dependent
     * @param education
     */
    public Employee(int id, String firstName, String lastName, String employmentId, Date startDate, String designation,
            String department, Date endDate, String status, Date dob, String reporting_Manager, String gender,
            String blood_Group, String address, List<Dependent> dependent, List<Education> education) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.employmentId = employmentId;
        this.startDate = startDate;
        this.designation = designation;
        this.department = department;
        this.endDate = endDate;
        this.status = status;
        this.dob = dob;
        this.reporting_Manager = reporting_Manager;
        this.gender = gender;
        this.blood_Group = blood_Group;
        this.address = address;
        this.dependent = dependent;
        this.education = education;
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
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the employmentId
     */
    public String getEmploymentId() {
        return employmentId;
    }

    /**
     * @param employmentId the employmentId to set
     */
    public void setEmploymentId(String employmentId) {
        this.employmentId = employmentId;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * @param designation the designation to set
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    /**
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(String department) {
        this.department = department;
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
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the dob
     */
    public Date getDob() {
        return dob;
    }

    /**
     * @param dob the dob to set
     */
    public void setDob(Date dob) {
        this.dob = dob;
    }

    /**
     * @return the reporting_Manager
     */
    public String getReporting_Manager() {
        return reporting_Manager;
    }

    /**
     * @param reporting_Manager the reporting_Manager to set
     */
    public void setReporting_Manager(String reporting_Manager) {
        this.reporting_Manager = reporting_Manager;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the blood_Group
     */
    public String getBlood_Group() {
        return blood_Group;
    }

    /**
     * @param blood_Group the blood_Group to set
     */
    public void setBlood_Group(String blood_Group) {
        this.blood_Group = blood_Group;
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
     * @return the dependent
     */
    public List<Dependent> getDependent() {
        return dependent;
    }

    /**
     * @param dependent the dependent to set
     */
    public void setDependent(List<Dependent> dependent) {
        this.dependent = dependent;
    }

    /**
     * @return the education
     */
    public List<Education> getEducation() {
        return education;
    }

    /**
     * @param education the education to set
     */
    public void setEducation(List<Education> education) {
        this.education = education;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "Employee [address=" + address + ", blood_Group=" + blood_Group + ", department=" + department
                + ", dependent=" + dependent + ", designation=" + designation + ", dob=" + dob + ", education="
                + education + ", employmentId=" + employmentId + ", endDate=" + endDate + ", firstName=" + firstName
                + ", gender=" + gender + ", id=" + id + ", lastName=" + lastName + ", reporting_Manager="
                + reporting_Manager + ", startDate=" + startDate + ", status=" + status + "]";
    }

}