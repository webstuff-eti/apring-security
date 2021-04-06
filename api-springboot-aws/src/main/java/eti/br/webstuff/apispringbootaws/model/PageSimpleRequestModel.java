package eti.br.webstuff.apispringbootaws.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PageSimpleRequestModel {

    private int page;
    private int size;
}
