package hello.itemservice.domain.item;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

//@Data 위험함. 분리해서 쓰길추천(get set)
@Getter @Setter
public class Item {
    private Long id;
    private String itemName;
    private Integer price; //null넣을수있도록 integer
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }


}
