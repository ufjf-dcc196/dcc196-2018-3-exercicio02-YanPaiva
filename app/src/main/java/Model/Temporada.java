package Model;

import java.util.ArrayList;

public class Temporada {
    private int numero;
    private String titulo;
    private ArrayList<Episodeo> episodeos;
    private int id;

    public Temporada() {
    }

    public int getId() {
        return id;
    }

    public Temporada setId(int id) {
        this.id = id;
        return this;
    }

    public ArrayList<Episodeo> getEpisodeos() {
        return episodeos;
    }

    public Temporada addEpisodeos(Episodeo episodeo) {
        this.episodeos.add(episodeo);
        return this;
    }
    public Temporada removeEpisodeos(Episodeo episodeo){
        if(episodeos.contains(episodeo))
            this.episodeos.remove(episodeo);
        return this;
    }

    public int getNumero() {
        return numero;
    }

    public Temporada setNumero(int numero) {
        this.numero = numero;
        return this;
    }

    public String getTitulo() {
        return titulo;
    }

    public Temporada setTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }
}
