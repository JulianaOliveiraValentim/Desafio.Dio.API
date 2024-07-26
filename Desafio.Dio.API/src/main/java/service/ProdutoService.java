package service;  

import model.Produto;  
import repository.ProdutoRepository;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  

import java.util.List;  

@Service  
public class ProdutoService {  

    @Autowired  
    private ProdutoRepository produtoRepository;  

    public List<Produto> listarTodos() {  
        return produtoRepository.findAll();  
    }  

    public Produto adicionar(Produto produto) {  
        return produtoRepository.save(produto);  
    }  

    public Produto atualizar(Long id, Produto produto) {  
        // Verifique se o produto existe antes de atualizar  
        return produtoRepository.save(produto);  
    }  

    public void deletar(Long id) {  
        produtoRepository.deleteById(id);  
    }  
}  