package io.github.xNicolosox.spring_data.domain.repository;

import io.github.xNicolosox.spring_data.domain.entity.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class ClientesRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Cliente salvar (Cliente cliente) {
        entityManager.persist(cliente);
        return cliente;
    }

    @Transactional
    public Cliente atualizar(Cliente cliente){
        entityManager.merge(cliente);
        return cliente;
    }

    @Transactional(readOnly = true)
    public List<Cliente> buscarPorNome (String nome){
        String jpql = "SELECT C FROM Cliente C WHERE C.nome LIKE :NOME";
        TypedQuery <Cliente> query = entityManager.createQuery(jpql, Cliente.class);
        query.setParameter("NOME", "%" + nome + "%");
        return query.getResultList();
    }

    @Transactional(readOnly = true)
    public List<Cliente> obter (){
        return entityManager.createQuery("FROM Cliente", Cliente.class).getResultList();
    }

    @Transactional
    public void deletar (Cliente cliente){
        if(!entityManager.contains(cliente)){
            cliente = entityManager.merge(cliente);
        }
        entityManager.remove(cliente);
    }
    @Transactional
    public void deletar (Integer id){
        Cliente cliente = entityManager.find(Cliente.class, id);
        entityManager.remove(cliente);
    }
}
