package pl.coderslab.charity.model;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;


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

    @ManyToMany
    @JoinTable (
            name="donation_category",
            joinColumns = @JoinColumn(name="donation_id"),
            inverseJoinColumns = @JoinColumn(name="category_id")

    )

    private List<Category> categories;

    @ManyToOne
    @JoinColumn(name="institution_id")
    private Institution institution;

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