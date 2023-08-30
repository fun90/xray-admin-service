package com.fun90.admin.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MessageReceiver extends BaseEntity implements Serializable {

	@ManyToOne
	private User user;
	@ManyToOne
	private Message message;
	/**
	 * 已经接收？
	 */
	private boolean received;

   /* @Override
    public MessageReceiverVO toVO() {
        UserVO userVO = new UserVO();
        userVO.setId(user.getId());

        MessageVO messageVO= new MessageVO();
        messageVO.setId(message.getId());
        return MessageReceiverVO.builder().user(userVO).message(messageVO).build();
    }*/


}

