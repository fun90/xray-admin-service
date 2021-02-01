package com.jhl.admin.VO;

import lombok.*;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MessageReceiverVO extends BaseEntityVO implements Serializable {

	private UserVO user;

	private MessageVO message;
	/**
	 * 已经接收？
	 */
	private boolean received;


}
