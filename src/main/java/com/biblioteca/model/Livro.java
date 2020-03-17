package com.biblioteca.model;

public class Livro {

	public int id;
	public String titulo;
	public String editora;
	public int numeroDePaginas;
	
	public Livro(int id, String titulo, String editora, int numeroDePaginas) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.editora = editora;
		this.numeroDePaginas = numeroDePaginas;
	}
	
	public Livro() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	public int getNumeroDePaginas() {
		return numeroDePaginas;
	}
	public void setNumeroDePaginas(int numeroDePaginas) {
		this.numeroDePaginas = numeroDePaginas;
	}

	@Override
	public String toString() {
		return "Livro [titulo= " + titulo + ", editora= " + editora + ", numeroDePaginas= " + numeroDePaginas + "]";
	}
	
	
	
}
