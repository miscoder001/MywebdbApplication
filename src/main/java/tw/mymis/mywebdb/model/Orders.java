package tw.mymis.mywebdb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


// 此種 class 只是對應資料庫內的某個資料表
// 本身並無任何程式邏輯
// 一般稱為 Data Class
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
