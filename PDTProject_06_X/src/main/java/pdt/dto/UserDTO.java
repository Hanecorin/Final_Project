package pdt.dto;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDTO {

	private String userId;

	private String pw;

	private String name;

	private String imgUrl;

}
