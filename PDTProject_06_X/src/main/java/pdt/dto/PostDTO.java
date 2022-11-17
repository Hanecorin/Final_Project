package pdt.dto;

import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PostDTO {

	private Long postId;

	private UserDTO userId;

	private String text;

	private String keyword;
	
	private String keyword1;
	
	private String keyword2;
	
	private String keyword3;
	
	private LocalDateTime createDate;
	
	private LocalDateTime updateDate;
	
	private Long likeCount;
	
	

}