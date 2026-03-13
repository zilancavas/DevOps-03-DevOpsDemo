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
public class NotizController {

    private Map<Integer, Notiz> eintraege = new HashMap<>();

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        this.eintraege.put(1, new Notiz(1, "REST Grundlagen", "GET = lesen, POST = erstellen, PUT = updaten, DELETE = löschen", "Theorie"));
        this.eintraege.put(2, new Notiz(2, "Screencast Tipps", "Max 60 Sekunden, mp4 Format, Hochdeutsch, ZHAW-Kürzel sichtbar", "Abgabe"));
    }

    @GetMapping("/services/notiz")
    public List<PathListEntry<Integer>> getAll() {
        var result = new ArrayList<PathListEntry<Integer>>();
        for (var eintrag : this.eintraege.values()) {
            var entry = new PathListEntry<Integer>();
            entry.setKey(eintrag.getId(), "notizKey");
            entry.setName(eintrag.getName());
            entry.getDetails().add(eintrag.getKategorie());
            entry.setTooltip(eintrag.getInhalt());
            result.add(entry);
        }
        return result.stream().sorted(Comparator.comparing(PathListEntry::getName)).toList();
    }

    @GetMapping("/services/notiz/{key}")
    public Notiz getById(@PathVariable("key") Integer key) {
        return this.eintraege.get(key);
    }

    @PostMapping("/services/notiz")
    public void create(@RequestBody Notiz eintrag) {
        var newId = this.eintraege.keySet().stream().max(Comparator.naturalOrder()).orElse(0) + 1;
        eintrag.setId(newId);
        this.eintraege.put(newId, eintrag);
    }

    @PutMapping("/services/notiz/{key}")
    public void update(@PathVariable("key") Integer key, @RequestBody Notiz eintrag) {
        eintrag.setId(key);
        this.eintraege.put(key, eintrag);
    }

    @DeleteMapping("/services/notiz/{key}")
    public Notiz delete(@PathVariable("key") Integer key) {
        return this.eintraege.remove(key);
    }
}
