package tw.mymis.mywebdb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Orders {
    int orderNumber;
    Date orderDate;
    Date requiredDate;
    String comments;
    String companyName;
}
