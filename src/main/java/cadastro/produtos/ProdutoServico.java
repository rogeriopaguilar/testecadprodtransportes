package cadastro.produtos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProdutoServico {

	@Autowired
	private ProdutoRepositorio repo;
	
	public List<Produto> listar() {
		return repo.findAll();
	}
	
	public void salvar(Produto product) {
		repo.save(product);
	}
	
	public Produto buscarPorId(long id) {
		return repo.findById(id).get();
	}
	
	public void apagar(long id) {
		repo.deleteById(id);
	}
}
