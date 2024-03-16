package com.cts.bookworm.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.cts.bookworm.entities.Orders;

public interface OrdersRepository extends CrudRepository<Orders, Integer> {

	@Query("select order from Orders order JOIN order.user u where u.userId = :userId")
	List<Orders> findUserOrderById(@Param("userId") int userId);

}
