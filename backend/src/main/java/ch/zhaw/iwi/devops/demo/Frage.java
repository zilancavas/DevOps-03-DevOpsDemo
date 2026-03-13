package ch.zhaw.iwi.devops.demo;

public class Frage {
    private Integer id;
    private String name;
    private String frage;
    private String status;
    private String antwort;

    public Frage() {}

    public Frage(Integer id, String name, String frage, String status, String antwort) {
        this.id = id;
        this.name = name;
        this.frage = frage;
        this.status = status;
        this.antwort = antwort;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getFrage() { return frage; }
    public void setFrage(String frage) { this.frage = frage; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getAntwort() { return antwort; }
    public void setAntwort(String antwort) { this.antwort = antwort; }
}
