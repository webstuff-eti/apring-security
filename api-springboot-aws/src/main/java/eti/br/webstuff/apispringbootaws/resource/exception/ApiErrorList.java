package eti.br.webstuff.apispringbootaws.resource.exception;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ApiErrorList extends ApiError {

    private static final long serialVersionUID = 1L;

    private List<String> errors;

    public ApiErrorList(int code, String msg, Date date, List<String> errors) {
        super(code, msg, date);
        this.errors = errors;
    }

}
