package eti.br.webstuff.apispringbootaws.exceptions;

public class GenericNotFoundException extends RuntimeException {

    private static final Long serialVersionUID = 1L;

    public GenericNotFoundException(String msg){
        super(msg);
    }

}
