package food.delivery.domain;

import food.delivery.domain.*;
import food.delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class CookStarted extends AbstractEvent {

    private Long id;
    private String orderId;
    private String storeId;
    private String menuId;
    private String qty;
    private String address;
    private String status;

    public CookStarted(Cook aggregate){
        super(aggregate);
    }
    public CookStarted(){
        super();
    }
}
