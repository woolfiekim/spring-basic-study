package hello.core.order;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemoryMemberRepository;

class OrderServiceImplTest {

    @Test
    void createOrder(){

        OrderServiceImpl orderService = new OrderServiceImpl();
        orderService.createOrder(1L, "itemA", 10000);

        /*
         * 위 코드는 빈으로 등록한 OrderServiceImpl를 사용하는 것이 아니라
         * 새로 OrderServiceImpl 객체 생성을 해서 사용하는 것이다.
         * 그러면 OrderServiceImpl에 의존성 주입(DI)했던 MemberRepository 등이 없다.(변수만 선언된 상태)
         * 그래서 아래의 코드를 실행하면 NullPolintException이 뜬다.(런타임에러)
         * (컴파일 에러는 코드 작성하면서 바로 알 수 있다. 런타임에러는 직접 코드를 실행해야 알 수 있다.)
         * 그러므로 생성자 의존성 주입을 해야한다.
         * 결론 : 아래의 코드(createOrder2)처럼 사용하면 된다.
         */
    }

    @Test
    void createOrder2(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        OrderServiceImpl orderBean = ac.getBean(OrderServiceImpl.class);
        MemoryMemberRepository memoryBean = ac.getBean(MemoryMemberRepository.class);
        memoryBean.save(new Member(1L, "name", Grade.VIP));
        Order order = orderBean.createOrder(1L, "itemCCC", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(2000);
    }

}