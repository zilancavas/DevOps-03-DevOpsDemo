package ch.zhaw.iwi.devops.demo;

public class Notiz {
    private Integer id;
    private String name;
    private String inhalt;
    private String kategorie;

    public Notiz() {}

    public Notiz(Integer id, String name, String inhalt, String kategorie) {
        this.id = id;
        this.name = name;
        this.inhalt = inhalt;
        this.kategorie = kategorie;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getInhalt() { return inhalt; }
    public void setInhalt(String inhalt) { this.inhalt = inhalt; }
    public String getKategorie() { return kategorie; }
    public void setKategorie(String kategorie) { this.kategorie = kategorie; }
}
