package ch.zhaw.iwi.devops.demo;

public class Leistungsnachweis {
    private Integer id;
    private String name;
    private String repoUrl;
    private String screencastStatus;
    private String screencastLaenge;
    private String peerReviewStatus;
    private String kommentar;

    public Leistungsnachweis() {}

    public Leistungsnachweis(Integer id, String name, String repoUrl, String screencastStatus, String screencastLaenge, String peerReviewStatus, String kommentar) {
        this.id = id;
        this.name = name;
        this.repoUrl = repoUrl;
        this.screencastStatus = screencastStatus;
        this.screencastLaenge = screencastLaenge;
        this.peerReviewStatus = peerReviewStatus;
        this.kommentar = kommentar;
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getRepoUrl() { return repoUrl; }
    public void setRepoUrl(String repoUrl) { this.repoUrl = repoUrl; }
    public String getScreencastStatus() { return screencastStatus; }
    public void setScreencastStatus(String screencastStatus) { this.screencastStatus = screencastStatus; }
    public String getScreencastLaenge() { return screencastLaenge; }
    public void setScreencastLaenge(String screencastLaenge) { this.screencastLaenge = screencastLaenge; }
    public String getPeerReviewStatus() { return peerReviewStatus; }
    public void setPeerReviewStatus(String peerReviewStatus) { this.peerReviewStatus = peerReviewStatus; }
    public String getKommentar() { return kommentar; }
    public void setKommentar(String kommentar) { this.kommentar = kommentar; }
}