package ac.kr.smu.tacos.domain;

import lombok.*;

import javax.persistence.*;



@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Ingredient{
    @Id
    private String id;
    @Column
    private String name;
    @Column
    @Enumerated(value = EnumType.STRING)
    private Type type;

    public static enum Type{
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
