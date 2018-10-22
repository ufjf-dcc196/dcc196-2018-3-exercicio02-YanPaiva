package Model;

import java.util.ArrayList;

public class Seriado {
    private ArrayList<Temporada> season;
    private String nome;

    public Seriado() {
    }

    public String getNome() {
        return nome;
    }

    public Seriado setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public ArrayList<Temporada> getSeason() {
        return season;
    }

    public Seriado addSeason(Temporada t){
        season.add(t);
        return this;
    }

    public Seriado removeSeason(Temporada t){
        if(season.contains(t))
            season.remove(t);
        return this;
    }
}
