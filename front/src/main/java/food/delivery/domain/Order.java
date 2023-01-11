package food.delivery.domain;

import food.delivery.domain.*;
import food.delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class Order extends AbstractEvent {

    private Long id;
    private String userId;
    private String storeId;
    private String menuId;
    private String qty;
    private String status;

    public Order(Order aggregate){
        super(aggregate);
    }
    public Order(){
        super();
    }
}
