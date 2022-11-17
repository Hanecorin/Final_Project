package pdt.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class IlikeDTO {
	
	private Long likeId;
	
	private String userId;
	
	private Long postId;

}
