package eti.br.webstuff.apispringbootaws.configuration.validation.msn;

public class ValidationProperties {

    public static final String REGEX_VALIDATION_CEP = "^[0-9]{8}$"; //FIXME: REVISAR NO TESTE DE VALIDAÇÃO
    public static final String REGEX_VALIDATION_DDD = "^[1-9]{2}$"; //FIXME: REVISAR NO TESTE DE VALIDAÇÃO
    public static final String REGEX_VALIDATION_FULL_NAME = "^[a-zA-ZA-Y]+\\s([a-zA-ZA-Y]\\s?)*[a-zA-ZA-Y][a-zA-ZA-Y]+\\s?$";         //FIXME: REVISAR NO TESTE DE VALIDAÇÃO
    public static final String REGEX_VALIDATION_PHONE = "^(9\\d{8})$";               //FIXME: REVISAR NO TESTE DE VALIDAÇÃO
    public static final String REGEX_VALIDATION_EMAIL = "^[a-zA-Z0-9.!#$%&'*+/=?^_ {|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$"; //FIXME: Concluir REGEX

    public static final String REGEX_VALIDATION_NUMERO = "(?:([a-zA-Z]+|)\\d+([a-zA-Z\\d]+|))"; //FIXME: REVISAR NO TESTE DE VALIDAÇÃO
    public static final String REGEX_VALIDATION_CITY_BIRTH = ".*([A-Za-za-u]){1}.*";            //FIXME: REVISAR NO TESTE DE VALIDAÇÃO
    public static final String REGEX_VALIDATION_CITY_LIVE = ".*([A-Za-za-u]){1}.*";             //FIXME: REVISAR NO TESTE DE VALIDAÇÃO
    public static final String REGEX_VALIDATION_PLACE = "^([a-zA-ZA-Y0-9]+\\s*)+";              //FIXME: REVISAR NO TESTE DE VALIDAÇÃO

    public static final String INVALID_REGEX_VALIDATION_CEP = "CEP invalido";
    public static final String INVALID_REGEX_VALIDATION_DDD = "DDD invalido";
    public static final String INVALID_REGEX_VALIDATION_FULL_NAME = "Nome invalido";
    public static final String INVALID_REGEX_VALIDATION_PHONE = "Celular invalido";
    public static final String INVALID_REGEX_VALIDATION_EMAIL = "E-mail invalido";
    public static final String INVALID_REGEX_VALIDATION_NUMERO = "Numero invalido";
    public static final String INVALID_REGEX_VALIDATION_CITY_BIRTH = "Cidade de nascimento invalida";
    public static final String INVALID_REGEX_VALIDATION_CITY_LIVE = "Cidade onde vive invalida";
    public static final String INVALID_REGEX_VALIDATION_PLACE = "Logradouro invalido";

}
