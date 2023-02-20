import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "courses")
public class Course {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private Integer duration;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column(name = "type", columnDefinition = "ENUM('design','programming','marketing','management','business')", nullable = false)
    private CourseType type;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    @ManyToOne (cascade = CascadeType.ALL)
    private Teacher teacher;

    @Getter
    @Setter
    @Column(name = "students_count")
    private Integer studentsCount;

    @Getter
    @Setter
    private Integer price;

    @Getter
    @Setter
    @Column(name = "price_per_hour")
    private Float pricePerHour;
}
