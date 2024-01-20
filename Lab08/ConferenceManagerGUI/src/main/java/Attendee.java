/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author SATYAM
 */
public class Attendee {
    private int id;
    private String fullName;
    private String email;
    private String contactNumber;
    private String country;

    public Attendee(int id, String fullName, String email, String contactNumber, String country) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.contactNumber = contactNumber;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Attendee{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

