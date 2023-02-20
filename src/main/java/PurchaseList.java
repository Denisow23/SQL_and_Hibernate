import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "purchaseList")
public class PurchaseList {

    @EmbeddedId
    @Getter
    @Setter
    private NameKey key;

    @Column(name = "student_name", insertable = false, updatable = false)
    private String studentName;

    @Column(name = "course_name", insertable = false, updatable = false)
    private String courseName;

    @Getter
    @Setter
    private Integer price;

    @Getter
    @Setter
    @Column(name = "subscription_date")
    private Date subscriptionDate;
}
