package net.oussama.micordemo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor

public class ResponseDto {
    private String Statuscode;
    private String Statusmessage;
}
