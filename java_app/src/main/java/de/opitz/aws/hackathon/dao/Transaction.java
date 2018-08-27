package de.opitz.aws.hackathon.dao;

import java.util.Calendar;

public class Transaction {
    private Calendar transactionDate;
    private String product;
    private Float price;
    private PaymentType paymentType;
    private String name;
    private String city;
    private String state;
    private String country;
    private Calendar accountCreated;
    private Calendar lastLogin;
    private Float latitude;
    private Float longitude;

    public Calendar getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Calendar transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Calendar getAccountCreated() {
        return accountCreated;
    }

    public void setAccountCreated(Calendar accountCreated) {
        this.accountCreated = accountCreated;
    }

    public Calendar getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Calendar lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionDate=" + transactionDate +
                ", product='" + product + '\'' +
                ", price=" + price +
                ", paymentType=" + paymentType +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", accountCreated=" + accountCreated +
                ", lastLogin=" + lastLogin +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
