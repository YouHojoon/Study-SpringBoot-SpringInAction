package ac.kr.smu.tacos.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;


@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Taco{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @CreationTimestamp
    @Temporal(value = TemporalType.DATE)
    private Date createdAt;

    @Column
    @NotNull
    @Size(min = 5, message = "Name must be at least 5 characters long")
    private String name;

    @OneToMany
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;
}
