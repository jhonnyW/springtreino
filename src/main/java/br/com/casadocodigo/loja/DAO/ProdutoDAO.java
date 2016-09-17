package br.com.casadocodigo.loja.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.casadocodigo.loja.models.Produto;
@Repository@Transactional
public class ProdutoDAO {
	
	@PersistenceContext
	private EntityManager manager;
	public void gravar(Produto produto){
		manager.persist(produto);
		
	}
	public List<Produto> listar() {
		return (List<Produto>) manager.createQuery("Select p from Produto p", Produto.class).getResultList();
	}
	public Produto find(Integer id) {
        return manager.createQuery("select distinct(p) from Produto p join fetch p.precos precos where p.id = :id", Produto.class).setParameter("id", id).getSingleResult();
	}
}
