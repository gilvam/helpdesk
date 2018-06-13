package com.gilvam.helpdesk.repository;

import com.gilvam.helpdesk.model.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TicketRepository extends MongoRepository<Ticket, String> {

	Page<Ticket> findByUserIdOrderByDateDesc(Pageable pages, String userId);

	Page<Ticket> findByTitleAndStatusAndPriorityOrderByDateDesc(
			String title, String status, String priority, Pageable pages);

	//	Page<Ticket> findByTitleIgnoreCaseContainingAndStatusAndPriorityAndUserIdOrderByDateDesc(
	//			String title, String status, String priority, Pageable pages);
	Page<Ticket> findByTitleIgnoreCaseContainingAndStatusAndPriorityAndUserIdOrderByDateDesc(
			String title, String status, String priority, String userId, Pageable pages);

	//	Page<Ticket> findByTitleIgnoreCaseContainingAndStatusAndPriorityAndAssignedUserOrderByDateDesc(
	//			String title, String status, String priority, Pageable pages);
	Page<Ticket> findByTitleIgnoreCaseContainingAndStatusAndPriorityAndAssignedUserOrderByDateDesc(
			String title, String status, String priority, String assignedUser, Pageable pages);

	Page<Ticket> findByNumber(Integer number, Pageable pages);
}