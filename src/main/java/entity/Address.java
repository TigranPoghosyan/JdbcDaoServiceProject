package entity;

import javax.annotation.Generated;
import java.util.Objects;

public class Address {

    private Long id;
    private String country;
    private String city;
    private String street;
    private String post_code;


    public Address(){}

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", post_code='" + post_code + '\'' +
                '}';
    }

    public Address(Long id, String country, String city, String street, String post_code) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.street = street;
        this.post_code = post_code;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) &&
                Objects.equals(country, address.country) &&
                Objects.equals(city, address.city) &&
                Objects.equals(street, address.street) &&
                Objects.equals(post_code, address.post_code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, city, street, post_code);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPost_code() {
        return post_code;
    }

    public void setPost_code(String post_code) {
        this.post_code = post_code;
    }
}
