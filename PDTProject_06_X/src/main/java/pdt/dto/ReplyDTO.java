package pdt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ReplyDTO {

	private Long replyId;

	private String userId;

	private Long postId;

	private String text;

}
