package pdt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pdt.dao.ReplyRepository;

import pdt.entity.Reply;
import pdt.entity.User;

@Service
public class ReplyServiceImp implements ReplyService {

	@Autowired
	private ReplyRepository replyRepo;

	public void insertReply(Reply reply) {
		replyRepo.save(reply);

	}

	public void deleteByUserId(User userId) {

		replyRepo.deleteByUserId(userId);

	}

}
