package eti.br.webstuff.apispringbootaws.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PageModel<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int totalElements;
    private int pageSize;
    private int totalPages;

    //FIXME: Lista de elementos contidos na página corrente
    private List<T> elements;
}
