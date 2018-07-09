package fr.training.spring.shop.application.order;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import fr.training.spring.shop.domain.customer.CustomerEntity;
import fr.training.spring.shop.domain.customer.CustomerRepository;
import fr.training.spring.shop.domain.customer.CustomerVO;
import fr.training.spring.shop.domain.item.ItemEntity;
import fr.training.spring.shop.domain.item.ItemRepository;
import fr.training.spring.shop.domain.item.ItemVO;
import fr.training.spring.shop.domain.order.OrderEntity;
import fr.training.spring.shop.domain.order.OrderRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class OrderServiceImplTest {

	@Autowired
	private OrderManagement orderManagement;

	@MockBean
	private OrderRepository orderRepository;

	@MockBean
	private CustomerRepository customerRepository;

	@MockBean
	private ItemRepository itemRepository;

	@Test
	public void testGetOrdersForCustomer() {
		OrderEntity orderEntity1 = this.createOrder("NASS", "123456", "DESC99", 99);
		OrderEntity orderEntity2 = this.createOrder("NASS", "123456", "DESC99", 99);
		List<OrderEntity> orders = Stream.of(orderEntity1, orderEntity2).collect(Collectors.toList());
		when(orderRepository.getOrdersForCustomer("123e4567-e89b-42d3-a456-556642440000")).thenReturn(orders);

		List<OrderEntity> ordersResult = orderManagement.getOrdersForCustomer("123e4567-e89b-42d3-a456-556642440000");

		assertNotNull(ordersResult);
		assertEquals(2, ordersResult.size());
	}

	@Test
	public void testAddOrder() {
		OrderEntity orderEntity = this.createOrder("NASS", "123456", "DESC99", 99);
		when(orderRepository.addOrder(orderEntity)).thenReturn(orderEntity);
		OrderEntity orderResult = orderManagement.addOrder(orderEntity);
		assertNotNull(orderResult);
	}

	private OrderEntity createOrder(String customerName, String customerPass, String itemDesc, int price) {
		CustomerEntity customer = new CustomerEntity(new CustomerVO("nass", "123456"));
		ItemEntity itemEntity = new ItemEntity(new ItemVO("DESC99", 99));
		OrderEntity orderEntity = new OrderEntity();
		orderEntity.setCustomer(customer);
		orderEntity.setItems(Arrays.asList(itemEntity));
		return orderEntity;
	}

}
