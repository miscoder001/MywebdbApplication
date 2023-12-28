package tw.mymis.mywebdb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Customer {
    private int customerNumber;
    private String name;
    private String phone;
    private String city;
    private String country;
    private Double creditLimit;
}
