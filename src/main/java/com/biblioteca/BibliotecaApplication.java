package com.biblioteca;

import java.util.ArrayList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.model.Livro;

@SpringBootApplication
@RestController
public class BibliotecaApplication {
	
	ArrayList<Livro> livros = new ArrayList<Livro>();
	Livro livro1 = new Livro(0,"qwe","asd",120);
	Livro livro2 = new Livro(1,"rty","fgh",120);

	public static void main(String[] args) {
		SpringApplication.run(BibliotecaApplication.class, args);
	}
	
	//rota apenas para adicionar itens para ser exibidos
	@GetMapping("/adiciona")
	public void soPraAdicionar() {
		livros.add(livro1);
		livros.add(livro2);
	}
	
	@GetMapping("/")
	public ArrayList<Livro> listaLivros() {
		return livros;
	}
	
	@GetMapping("/livro/{id}")
	public String exibiLivro(@PathVariable int id) {
		String txt = "Seu livro: ";
		for (int i = 0; i < livros.size(); i++) {
			if(livros.get(i).getId() == id) {
				txt = txt.concat(livros.get(i).getTitulo());
			}else {
				txt = txt.concat("Não existe");
			}
		}
		return txt;
	}
	
	@PostMapping("/livro")
	public String cadastraLivro(@RequestBody Livro livro) {
		livros.add(livro);
		return "Livro cadastrado";
	}
	
	@DeleteMapping("/livro/{id}")
	public String deletarLivro(@PathVariable int id) {
		String txt = "Livro: ";
		for (int i = 0; i < livros.size(); i++) {
			if(livros.get(i).getId() == id) {
				txt = txt.concat(livros.get(i).getTitulo());
				livros.remove(i);
			}else {
				txt = txt.concat("Nao existe!");
			}
		} 
		return txt;
	}
	
	@PutMapping("/livro/{id}")
	public String atualizarLivro(@PathVariable int id, @RequestBody Livro livro) {
		for (int i = 0; i < livros.size(); i++) {
			if(livros.get(i).getId() == id) {
				livros.remove(i);
				livros.add(livro);
			}
		}
		
		return "Alterado com sucesso";
	}

}
