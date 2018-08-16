package com.ordercommandapi.ordercommandapi;

import com.ordercommandapi.ordercommandapi.service.OrderService;
import com.ordercommandapi.ordercommandapi.service.model.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.after;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class OrderCommandApiApplicationTests {

	@Mock
	OrderService orderService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testFallback(){

		Order order = new Order();
//		// when
//		AsyncResult<Void> future = (AsyncResult<Void>) orderService.createOrder(order);
//		future.invoke();
		// then

//		Mockito.when(orderService.createOrder(any(Order.class))).thenReturn(null);
		orderService.createOrder(order);
		verify(orderService, after(10000)).createOrder(order);

		//		Future<Order> orderFuture =  orderService.createOrder(order);
//
//		when(orderService.createOrder(order)).thenCallRealMethod()



	}

}
