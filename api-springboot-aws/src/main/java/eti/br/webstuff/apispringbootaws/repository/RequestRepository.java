package eti.br.webstuff.apispringbootaws.repository;

import eti.br.webstuff.apispringbootaws.entity.Request;
import eti.br.webstuff.apispringbootaws.enums.RequestStateEnum;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {

    //FIXME: BUSCAR UMA LISTA DE PEDIDOS DADO O ID DO USUÁRIO - Testing
    public List<Request> findAllByUserId(Long id);

    //FIXME: Alterar estado do pedido quando adicionarmos um novo estágio
    //FIXME: RETORNA O NÚMERO DE LINHAS QUE SERÃO AFETADAS PELO UPDATE
    @Transactional(readOnly = false)
    @Modifying
    @Query("UPDATE request SET stateEnum = ?2 WHERE id = ?1")
    public int updateStatus(Long id, RequestStateEnum stateEnum);

}
