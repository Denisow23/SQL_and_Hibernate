
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.SQLInsert;
import org.hibernate.annotations.SQLUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Subscriptions")
public class Subscription {

    @EmbeddedId
    private IdKey key;

    @Getter
    @Setter
    @Column(name = "subscription_date")
    private Date subscriptionDate;

    @EqualsAndHashCode
    @ToString
    @Embeddable
    public class IdKey implements Serializable {

        @Getter
        @Setter
        @ManyToOne(cascade = CascadeType.ALL)
        private Student student;


        @Getter
        @Setter
        @ManyToOne(cascade = CascadeType.ALL)
        private Course course;
    }
}



