package ac.kr.smu.tacos.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    private Date placeAt;

    @NotBlank(message = "Name is required")
    @Column
    private String deliveryName;
    @NotBlank(message = "Street is required")
    @Column
    private String deliveryStreet;

    @NotBlank(message = "City is required")
    @Column
    private String deliveryCity;

    @NotBlank(message = "State is required")
    @Column
    private String deliveryState;

    @NotBlank(message = "Zip is required")
    @Column
    private String deliveryZip;

    @CreditCardNumber
    @Column
    private String ccNumber;

    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message = "Must be formatted MM/YY")
    @Column
    private String ccExpiration;

    @Digits(integer = 3, fraction = 0, message = "Invalid CVV")
    @Column
    private String ccCVV;

    @OneToMany
    private List<Taco> tacos=new ArrayList<>();

    public void addTaco(Taco taco){
        this.tacos.add(taco);
    }

}
