package pdt.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import pdt.entity.Ilike;
import pdt.entity.Post;
import pdt.entity.User;

public interface IlikeRepository extends JpaRepository<Ilike, Long> {
	
	Optional<Ilike> findByUserIdAndPostId(User userId, Post postId);
	
	void deleteByUserIdAndPostId(User userId, Post postId);
	
	void deleteByUserId(User userId);

}
