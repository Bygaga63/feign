package home.feign.model;

import lombok.Data;

@Data
public class User {
    Long id;
    String name;
    String username;
    String email;
    Address address;
    String phone;
    String website;
    Company company;
}

@Data
class Address {
    String street;
    String suite;
    String city;
    String zipcode;
    Geo geo;
}

@Data
class Geo {
    String lat;
    String lng;
}

@Data
class Company {
    String name;
    String catchphrase;
    String bs;
}