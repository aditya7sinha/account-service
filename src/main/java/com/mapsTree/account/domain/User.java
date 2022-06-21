package com.mapsTree.account.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="user_data",uniqueConstraints = { @UniqueConstraint(name = "UniqueUserName",
        columnNames = "username") })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name="sequenceGenerator")
    @Column(name="id")
    private Long id;
    @Column(name="username",unique = true)
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="age")
    private Integer age;
    @Column(name="phoneNumber")
    private String phoneNumber;
    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(unique = true)
    private HomeLocation homeLocation;
    @Column(name="country")
    private String country;
    @Column(name="timeOfCreation")
    private String timeOfCreation;

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setHomeLocation(HomeLocation homeLocation) {
        this.homeLocation = homeLocation;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setTimeOfCreation(String timeOfCreation) {
        this.timeOfCreation = timeOfCreation;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Integer getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public HomeLocation getHomeLocation() {
        return homeLocation;
    }

    public String getCountry() {
        return country;
    }

    public String getTimeOfCreation() {
        return timeOfCreation;
    }

    public String getPassword() {
        return password;
    }


    public User(Long id, String username, String password, Integer age, String phoneNumber, HomeLocation homeLocation, String country, String timeOfCreation) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.homeLocation = homeLocation;
        this.country = country;
        this.timeOfCreation = timeOfCreation;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", homeLocation=" + homeLocation +
                ", country='" + country + '\'' +
                ", timeOfCreation='" + timeOfCreation + '\'' +
                '}';
    }
}
