package food.delivery.domain;

import food.delivery.domain.Notified;
import food.delivery.CustomerApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Notification_table")
@Data

public class Notification  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;

    @PostPersist
    public void onPostPersist(){


        Notified notified = new Notified(this);
        notified.publishAfterCommit();

    }

    public static NotificationRepository repository(){
        NotificationRepository notificationRepository = CustomerApplication.applicationContext.getBean(NotificationRepository.class);
        return notificationRepository;
    }




    public static void notifyViaKakao(Accepted accepted){

        /** Example 1:  new item 
        Notification notification = new Notification();
        repository().save(notification);

        */

        /** Example 2:  finding and process
        
        repository().findById(accepted.get???()).ifPresent(notification->{
            
            notification // do something
            repository().save(notification);


         });
        */

        
    }
    public static void notifyViaKakao(Rejected rejected){

        /** Example 1:  new item 
        Notification notification = new Notification();
        repository().save(notification);

        */

        /** Example 2:  finding and process
        
        repository().findById(rejected.get???()).ifPresent(notification->{
            
            notification // do something
            repository().save(notification);


         });
        */

        
    }
    public static void notifyViaKakao(DelivaryStarted delivaryStarted){

        /** Example 1:  new item 
        Notification notification = new Notification();
        repository().save(notification);

        */

        /** Example 2:  finding and process
        
        repository().findById(delivaryStarted.get???()).ifPresent(notification->{
            
            notification // do something
            repository().save(notification);


         });
        */

        
    }


}
