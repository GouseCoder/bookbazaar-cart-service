package com.bookbazaar.hub.cartservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bookbazaar.hub.cartservice.entity.Book;
import com.bookbazaar.hub.cartservice.entity.MyCart;
import com.bookbazaar.hub.cartservice.entity.UserInfo;

public interface CartRepository extends JpaRepository<MyCart, Long>{

	MyCart findByUserAndBook(UserInfo user, Book book);

	List<MyCart> findByUser(UserInfo user);
	
	@Query("SELECT COUNT(c.cartId) FROM MyCart c WHERE c.user.userId = :userId")
	int countByUserId(@Param("userId") Long userId);

}
