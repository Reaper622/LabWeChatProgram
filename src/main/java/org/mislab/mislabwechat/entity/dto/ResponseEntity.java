package org.mislab.mislabwechat.entity.dto;

import lombok.Data;

@Data
public class ResponseEntity<T>{
    private int status;
    private String message;
    private T data;

    public ResponseEntity(int status, String message, T data){
        this.status = status;
        this.message = message;
        this.data = data;
    }

}
