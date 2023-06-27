
package pl.coderslab.charity.model;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;



@Entity
@Table(name = "categories")
@Getter
@Setter

public class Category {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="category_id")
    private long id;

    @Column (name="name")
    private String name;




}