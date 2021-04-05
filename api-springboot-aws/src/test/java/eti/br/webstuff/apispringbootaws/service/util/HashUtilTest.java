package eti.br.webstuff.apispringbootaws.service.util;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
public class HashUtilTest {

    //FIXME: SpringBootTest -> carregar o contexto do projeto,
    //como iremos testar uma classe simples, usaremos p SpringRuner

    @Test
    public void getSecureHashTest(){

        String hash = HashUtil.getSecureHash("123");
        System.out.println("VAlor hash:" + hash);

        assertThat(hash.length()).isEqualTo(64);
    }


}
