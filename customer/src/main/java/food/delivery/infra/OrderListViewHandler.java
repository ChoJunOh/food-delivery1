package food.delivery.infra;

import food.delivery.domain.*;
import food.delivery.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class OrderListViewHandler {

    @Autowired
    private OrderListRepository orderListRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryStarted_then_CREATE_1 (@Payload DeliveryStarted deliveryStarted) {
        try {

            if (!deliveryStarted.validate()) return;

            // view 객체 생성
            OrderList orderList = new OrderList();
            // view 객체에 이벤트의 Value 를 set 함
            orderList.setOrderId(DeliveryStarred);
            // view 레파지 토리에 save
            orderListRepository.save(orderList);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookStarted_then_CREATE_2 (@Payload CookStarted cookStarted) {
        try {

            if (!cookStarted.validate()) return;

            // view 객체 생성
            OrderList orderList = new OrderList();
            // view 객체에 이벤트의 Value 를 set 함
            orderList.setOrderId(cookStarted.getOrderId());
            // view 레파지 토리에 save
            orderListRepository.save(orderList);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderFinsihed_then_UPDATE_1(@Payload OrderFinsihed orderFinsihed) {
        try {
            if (!orderFinsihed.validate()) return;
                // view 객체 조회

                List<OrderList> orderListList = orderListRepository.findByOrderId(orderFinsihed.getOrderId());
                for(OrderList orderList : orderListList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderList.setStatus(orderFinsihed.getStatus());
                // view 레파지 토리에 save
                orderListRepository.save(orderList);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookFinished_then_UPDATE_2(@Payload CookFinished cookFinished) {
        try {
            if (!cookFinished.validate()) return;
                // view 객체 조회

                List<OrderList> orderListList = orderListRepository.findByOrderId(cookFinished.getOrderId());
                for(OrderList orderList : orderListList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderList.setStatus(cookFinished.getStatus());
                // view 레파지 토리에 save
                orderListRepository.save(orderList);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenAccepted_then_UPDATE_3(@Payload Accepted accepted) {
        try {
            if (!accepted.validate()) return;
                // view 객체 조회

                List<OrderList> orderListList = orderListRepository.findByOrderId(accepted.getOrderId());
                for(OrderList orderList : orderListList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderList.setStatus(accepted.getStatus());
                // view 레파지 토리에 save
                orderListRepository.save(orderList);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenCookStarted_then_UPDATE_4(@Payload CookStarted cookStarted) {
        try {
            if (!cookStarted.validate()) return;
                // view 객체 조회

                List<OrderList> orderListList = orderListRepository.findByOrderId(cookStarted.getOrderId());
                for(OrderList orderList : orderListList){
                    // view 객체에 이벤트의 eventDirectValue 를 set 함
                    orderList.setStatus(cookStarted.getStatus());
                // view 레파지 토리에 save
                orderListRepository.save(orderList);
                }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenRejected_then_DELETE_1(@Payload Rejected rejected) {
        try {
            if (!rejected.validate()) return;
            // view 레파지 토리에 삭제 쿼리
            orderListRepository.deleteByOrderId(rejected.getOrderId());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}

