package pdt.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pdt.entity.Post;
import pdt.entity.Reply;
import pdt.entity.User;

public interface ReplyRepository extends JpaRepository<Reply, Long> {

	public List<Reply> findByPostId(Post postId);

	void deleteByUserIdAndPostId(User userId, Post postId);

	void deleteByUserId(User userId);

}
