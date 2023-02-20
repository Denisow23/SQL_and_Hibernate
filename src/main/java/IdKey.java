import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@EqualsAndHashCode
@ToString
@Embeddable
public class IdKey implements Serializable {

    @Getter
    @Setter
    @Column(name = "student_id")
    private Integer studentId;

    @Getter
    @Setter
    @Column(name = "course_id")
    private Integer courseID;
}
