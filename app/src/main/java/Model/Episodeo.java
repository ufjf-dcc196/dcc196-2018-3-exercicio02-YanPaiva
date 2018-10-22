package Model;

public class Episodeo {
    private int numero;
    private String titulo;
    private int id;

    public Episodeo() {
    }

    public int getId() {
        return id;
    }

    public Episodeo setId(int id) {
        this.id = id;
        return this;
    }

    public int getNumero() {
        return numero;
    }

    public Episodeo setNumero(int numero) {
        this.numero = numero;
        return this;
    }

    public String getTitulo() {
        return titulo;
    }

    public Episodeo setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }
}
