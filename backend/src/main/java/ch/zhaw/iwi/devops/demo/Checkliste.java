package ch.zhaw.iwi.devops.demo;

public class Checkliste {
    private Integer id;
    private String name;
    private String version;
    private String status;

    public Checkliste() {}

    public Checkliste(Integer id, String name, String version, String status) {
        this.id = id;
        this.name = name;
        this.version = version;
        this.status = status;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getVersion() { return version; }
    public void setVersion(String version) { this.version = version; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}