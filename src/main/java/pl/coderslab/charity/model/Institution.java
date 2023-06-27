package pl.coderslab.charity.model;
import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "institutions")
@Getter
@Setter
public class Institution {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="institution_id")
    private Long id;

    @Column (name="name")
    private String name;

    @Column (name="description")
    private String description;



}
