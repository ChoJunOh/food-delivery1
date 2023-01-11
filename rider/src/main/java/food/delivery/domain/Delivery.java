package food.delivery.domain;

import food.delivery.domain.DelivaryStarted;
import food.delivery.domain.OrderFinsihed;
import food.delivery.RiderApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Delivery_table")
@Data

public class Delivery  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String orderId;
    
    
    
    
    
    private String storeId;
    
    
    
    
    
    private String menuId;
    
    
    
    
    
    private String address;
    
    
    
    
    
    private String riderId;
    
    
    
    
    
    private String status;

    @PostPersist
    public void onPostPersist(){


        DelivaryStarted delivaryStarted = new DelivaryStarted(this);
        delivaryStarted.publishAfterCommit();



        OrderFinsihed orderFinsihed = new OrderFinsihed(this);
        orderFinsihed.publishAfterCommit();

    }

    public static DeliveryRepository repository(){
        DeliveryRepository deliveryRepository = RiderApplication.applicationContext.getBean(DeliveryRepository.class);
        return deliveryRepository;
    }




    public static void cookInfoTransfer(CookStarted cookStarted){

        /** Example 1:  new item 
        Delivery delivery = new Delivery();
        repository().save(delivery);

        */

        /** Example 2:  finding and process
        
        repository().findById(cookStarted.get???()).ifPresent(delivery->{
            
            delivery // do something
            repository().save(delivery);


         });
        */

        
    }


}
