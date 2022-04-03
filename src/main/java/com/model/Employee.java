package com.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {
	@Id
	@GeneratedValue
	private int id;
	private String fname;
	private String lname;
	private int salary;
	private int age;
	@OneToOne
	@JoinColumn(name = "addressId")
	private Address address;

	@OneToMany(mappedBy = "employee")
	private List<Phone> phones;
	@ManyToMany
	@JoinTable(name = "empdept", joinColumns = {
			/* talking column from employee table */ @JoinColumn(name = "empId") }, inverseJoinColumns = {
					/*talking column from dept table*/@JoinColumn(name = "deptId") })
	private List<Department> deptList;

	/**
	 * @return the deptList
	 */
	public List<Department> getDeptList() {
		return deptList;
	}

	/**
	 * @param deptList the deptList to set
	 */
	public void setDeptList(List<Department> deptList) {
		this.deptList = deptList;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	/**
	 * @param phones the phones to set
	 */
	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	public Employee() {

	}

	public Employee(String fname, String lname, int salary, int age, Address address) {
		this.fname = fname;
		this.lname = lname;
		this.salary = salary;
		this.age = age;
		this.address = address;
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
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}

	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}

	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}

	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}

	/**
	 * @return the salary
	 */
	public int getSalary() {
		return salary;
	}

	/**
	 * @param salary the salary to set
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}

}
