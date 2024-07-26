package controller;  

import model.Produto;  
import service.ProdutoService;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.http.HttpStatus;  
import org.springframework.http.ResponseEntity;  
import org.springframework.web.bind.annotation.*;  

import java.util.List;  

@RestController  
@RequestMapping("/api/produtos")  
public class ProdutoController {  

    @Autowired  
    private ProdutoService produtoService;  

    @GetMapping  
    public ResponseEntity<List<Produto>> listarProdutos() {  
        return new ResponseEntity<>(produtoService.listarTodos(), HttpStatus.OK);  
    }  

    @PostMapping  
    public ResponseEntity<Produto> adicionarProduto(@RequestBody Produto produto) {  
        return new ResponseEntity<>(produtoService.adicionar(produto), HttpStatus.CREATED);  
    }  

    @PutMapping("/{id}")  
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {  
        return new ResponseEntity<>(produtoService.atualizar(id, produto), HttpStatus.OK);  
    }  

    @DeleteMapping("/{id}")  
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id) {  
        produtoService.deletar(id);  
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);  
    }  
}  