package com.bookclients.bookingclients_service.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.bookclients.bookingclients_service.models.User;

public interface UserRepository {
	Optional<User> findByUsername(String username);

	Optional<User> findById(UUID id);

	User save(User user);

	User update(User user);

	boolean existUserId(UUID id);

	List<UUID> findAllId();
}
