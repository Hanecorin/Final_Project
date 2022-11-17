package pdt.service;


import pdt.entity.Reply;
import pdt.entity.User;

public interface ReplyService {
	
	void insertReply(Reply reply);
	
	void deleteByUserId(User userId);

}
