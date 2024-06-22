package com.samyakj820.smart_contact_manager.helper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    private String content;
    
    @Builder.Default
    private MessageType type = MessageType.blue; 
}
