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
public class FrageController {

    private Map<Integer, Frage> eintraege = new HashMap<>();

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        this.eintraege.put(1, new Frage(1, "Screencast Format", "Muss der Screencast zwingend auf Hochdeutsch sein?", "beantwortet", "Ja, Hochdeutsch ist Pflicht."));
        this.eintraege.put(2, new Frage(2, "Peer Review", "Wie viele LNs müssen wir pro Peer Review bewerten?", "offen", ""));
    }

    @GetMapping("/services/frage")
    public List<PathListEntry<Integer>> getAll() {
        var result = new ArrayList<PathListEntry<Integer>>();
        for (var eintrag : this.eintraege.values()) {
            var entry = new PathListEntry<Integer>();
            entry.setKey(eintrag.getId(), "frageKey");
            entry.setName(eintrag.getName());
            entry.getDetails().add(eintrag.getStatus());
            entry.setTooltip(eintrag.getFrage());
            result.add(entry);
        }
        return result.stream().sorted(Comparator.comparing(PathListEntry::getName)).toList();
    }

    @GetMapping("/services/frage/{key}")
    public Frage getById(@PathVariable("key") Integer key) {
        return this.eintraege.get(key);
    }

    @PostMapping("/services/frage")
    public void create(@RequestBody Frage eintrag) {
        var newId = this.eintraege.keySet().stream().max(Comparator.naturalOrder()).orElse(0) + 1;
        eintrag.setId(newId);
        this.eintraege.put(newId, eintrag);
    }

    @PutMapping("/services/frage/{key}")
    public void update(@PathVariable("key") Integer key, @RequestBody Frage eintrag) {
        eintrag.setId(key);
        this.eintraege.put(key, eintrag);
    }

    @DeleteMapping("/services/frage/{key}")
    public Frage delete(@PathVariable("key") Integer key) {
        return this.eintraege.remove(key);
    }
}