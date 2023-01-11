package food.delivery.domain;

import food.delivery.domain.*;
import food.delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class OrderFinsihed extends AbstractEvent {

    private Long id;
    private String orderId;
    private String storeId;
    private String menuId;
    private String address;
    private String riderId;
    private String status;

    public OrderFinsihed(Delivery aggregate){
        super(aggregate);
    }
    public OrderFinsihed(){
        super();
    }
}
