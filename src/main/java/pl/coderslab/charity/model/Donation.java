package pl.coderslab.charity.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;




@Entity
@Table(name = "donations")
@Getter
@Setter
public class Donation {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="donation_id")
    private Long id;
    @Column (name="quantity")
    private Integer quantity;

    //todo dodać połączenie one to many z category

    //todo dodać połączenie one to many z institution

    @Column (name="street")
    private String street;

    @Column(name="city")
    private String city;

    @Column(name="zip_code")
    private String zipCode;

    @Column(name="pickup_date")
    private String pickUpDate;  // todo jaki tutaj będzie rodzaj danych LocalDate?

    @Column(name="pickup_time")
    private String pickUpTime;  // todo jaki tutaj będzie rodzaj danych LocalTime?

    @Column(name="pickup_comment")
    private String pickUpComment;


}
