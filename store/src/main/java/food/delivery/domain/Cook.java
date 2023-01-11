package food.delivery.domain;

import food.delivery.domain.Accepted;
import food.delivery.domain.Rejected;
import food.delivery.domain.CookStarted;
import food.delivery.domain.CookFinished;
import food.delivery.StoreApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Cook_table")
@Data

public class Cook  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String orderId;
    
    
    
    
    
    private String storeId;
    
    
    
    
    
    private String menuId;
    
    
    
    
    
    private String qty;
    
    
    
    
    
    private String address;
    
    
    
    
    
    private String status;

    @PostPersist
    public void onPostPersist(){


        Accepted accepted = new Accepted(this);
        accepted.publishAfterCommit();



        Rejected rejected = new Rejected(this);
        rejected.publishAfterCommit();



        CookStarted cookStarted = new CookStarted(this);
        cookStarted.publishAfterCommit();



        CookFinished cookFinished = new CookFinished(this);
        cookFinished.publishAfterCommit();

    }

    public static CookRepository repository(){
        CookRepository cookRepository = StoreApplication.applicationContext.getBean(CookRepository.class);
        return cookRepository;
    }




    public static void orderInfoTranser(Order order){

        /** Example 1:  new item 
        Cook cook = new Cook();
        repository().save(cook);

        */

        /** Example 2:  finding and process
        
        repository().findById(order.get???()).ifPresent(cook->{
            
            cook // do something
            repository().save(cook);


         });
        */

        
    }
    public static void cancelCook(OrderCancelled orderCancelled){

        /** Example 1:  new item 
        Cook cook = new Cook();
        repository().save(cook);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderCancelled.get???()).ifPresent(cook->{
            
            cook // do something
            repository().save(cook);


         });
        */

        
    }


}
