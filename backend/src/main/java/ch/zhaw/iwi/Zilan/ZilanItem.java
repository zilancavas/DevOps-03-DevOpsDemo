package ch.zhaw.iwi.zilan;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class ZilanItem {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String beschreibung;
    private String startDatum;
    private String endDatum;

    // Getter & Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBeschreibung() { return beschreibung; }
    public void setBeschreibung(String beschreibung) { this.beschreibung = beschreibung; }

    public String getStartDatum() { return startDatum; }
    public void setStartDatum(String startDatum) { this.startDatum = startDatum; }

    public String getEndDatum() { return endDatum; }
    public void setEndDatum(String endDatum) { this.endDatum = endDatum; }
}
