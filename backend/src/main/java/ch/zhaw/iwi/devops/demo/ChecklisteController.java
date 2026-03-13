package ch.zhaw.iwi.devops.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class ChecklisteController {

    private Map<Integer, Checkliste> eintraege = new HashMap<>();

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        this.eintraege.put(1, new Checkliste(1, "Git-Client", "2.51.2", "installiert"));
        this.eintraege.put(2, new Checkliste(2, "Java", "25.0.1", "installiert"));
        this.eintraege.put(3, new Checkliste(3, "Gradle", "9.2.1", "installiert"));
        this.eintraege.put(4, new Checkliste(4, "Visual Studio Code", "1.106.2", "installiert"));
        this.eintraege.put(5, new Checkliste(5, "Node", "24.11.1", "installiert"));
        this.eintraege.put(6, new Checkliste(6, "NPM", "11.6.2", "installiert"));
        this.eintraege.put(7, new Checkliste(7, "Docker Desktop", "4.52.0", "nicht installiert"));
        this.eintraege.put(8, new Checkliste(8, "Postman", "-", "installiert"));
    }

    @GetMapping("/services/checkliste")
    public List<PathListEntry<Integer>> getAll() {
        var result = new ArrayList<PathListEntry<Integer>>();
        for (var eintrag : this.eintraege.values()) {
            var entry = new PathListEntry<Integer>();
            entry.setKey(eintrag.getId(), "checklisteKey");
            entry.setName(eintrag.getName());
            entry.getDetails().add(eintrag.getVersion());
            entry.setTooltip(eintrag.getStatus());
            result.add(entry);
        }
        return result.stream().sorted(Comparator.comparing(PathListEntry::getName)).toList();
    }

    @GetMapping("/services/checkliste/{key}")
    public Checkliste getById(@PathVariable("key") Integer key) {
        return this.eintraege.get(key);
    }

    @PostMapping("/services/checkliste")
    public void create(@RequestBody Checkliste eintrag) {
        var newId = this.eintraege.keySet().stream().max(Comparator.naturalOrder()).orElse(0) + 1;
        eintrag.setId(newId);
        this.eintraege.put(newId, eintrag);
    }

    @PutMapping("/services/checkliste/{key}")
    public void update(@PathVariable("key") Integer key, @RequestBody Checkliste eintrag) {
        eintrag.setId(key);
        this.eintraege.put(key, eintrag);
    }

    @DeleteMapping("/services/checkliste/{key}")
    public Checkliste delete(@PathVariable("key") Integer key) {
        return this.eintraege.remove(key);
    }
}