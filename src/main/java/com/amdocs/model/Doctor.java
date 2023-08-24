package com.amdocs.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "doctors")
public class Doctor {

    private int id;
    private String name;
    private String qualification;
    private String gender;
    private Date dateOfBirth;
    private int patientId;
    
    public Doctor() {

    }
    
    public Doctor(int id, String name, String qualification, String gender, Date dateOfBirth, int patientId) {
		super();
		this.id = id;
		this.name = name;
		this.qualification = qualification;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.patientId = patientId;
	}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "D_name", nullable = false)
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "D_qualification", nullable = false)
	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	@Column(name = "D_gender", nullable = false)
	public String getGender() {
		return gender;
	}

	public void setSex(String gender) {
		this.gender = gender;
	}
	
	@Column(name = "D_dob", nullable = false)
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Column(name = "P_Id", nullable = false)
	public int getP_id() {
		return patientId;
	}

	public void setP_id(int patientId) {
		this.patientId = patientId;
	}
    
}