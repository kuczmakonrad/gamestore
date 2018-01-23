package com.kk.gamestore.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "USER")
public class User {
	private static long idUser;

	@Id
	@Column(name = "id_user")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	@NotEmpty(message = "{NotEmpty.User.name.validation}")
	private String name;

	@Column(name = "surname")
	@NotEmpty(message = "{NotEmpty.User.surname.validation}")
	private String surname;


	@Column(name = "street")
	@NotEmpty(message = "{NotEmpty.User.street.validation}")
	private String street;
	
	@Column(name = "house_number")
	@NotEmpty(message = "{NotEmpty.User.houseNumber.validation}")
	private String houseNumber;

	
	@Column(name = "id_city")
	@NotEmpty(message = "{NotEmpty.User.cityId.validation}")
	private String cityId;

	@Column(name = "city")
	@NotEmpty(message = "{NotEmpty.User.city.validation}")
	private String city;

	@Column(name = "country")
	@NotEmpty(message = "{NotEmpty.User.country.validation}")
	private String country;

	@Column(name = "phone_number")
	@Size(min = 9, max = 9, message = "{Size.User.phoneNumber.validation}")
	private String phoneNumber;

	@Column(name = "email_adress")
	@Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$", message = "{Regexp.User.emailAdress.validation}")
	private String emailAdress;

	@Size (min=4, max=50, message="{Size.User.userLogin.validation}")
	@Column(name = "user_login")
	@NotEmpty(message = "{NotEmpty.User.userLogin.validation}")
	private String userLogin;

	@Size (min=5, max=50, message="{Size.User.userPassword.validation}")
	@Column(name = "user_password")
	@NotEmpty(message = "{NotEmpty.User.userPassword.validation}")
	private String userPassword;

	public static long getIdUser() {
		return idUser;
	}

	public static void setIdUser(long idUser) {
		User.idUser = idUser;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCityId() {
		return cityId;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailAdress() {
		return emailAdress;
	}

	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public User() {
		super();
		incrementID();
	}

	public long incrementID() {
		return ++idUser;
	}

	@Override
	public String toString(){
		return "id="+ id + ", name=" + name + ", surname=" + surname + ", street=" + street + ", house number=" + houseNumber + ", city code=" + cityId + ", city=" + city + ", country=" + country;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

}
