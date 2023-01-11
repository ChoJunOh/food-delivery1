package food.delivery.domain;

import food.delivery.domain.*;
import food.delivery.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class CookFinished extends AbstractEvent {

    private Long id;
    private String orderId;
    private String storeId;
    private String menuId;
    private String qty;
    private String address;
    private String status;

    public CookFinished(Cook aggregate){
        super(aggregate);
    }
    public CookFinished(){
        super();
    }
}
