package eti.br.webstuff.apispringbootaws.resource.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ApiError implements Serializable {

    private static final long serialVersionUID = 1L;

    //FIXME: Code HTTP
    private int code;
    //FIXME: MENSAGEM
    private String msg;
    private Date date;
}
