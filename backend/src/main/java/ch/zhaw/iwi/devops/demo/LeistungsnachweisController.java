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
public class LeistungsnachweisController {

    private Map<Integer, Leistungsnachweis> ln0103 = new HashMap<>();
    private Map<Integer, Leistungsnachweis> ln0406 = new HashMap<>();
    private Map<Integer, Leistungsnachweis> ln0710 = new HashMap<>();

    @EventListener(ApplicationReadyEvent.class)
    public void init() {
        ln0103.put(1, new Leistungsnachweis(1, "LN01", "https://github.com/zilancavas/DevOps-01-Version-Control-digialor-cavaszil", "hochgeladen", "58", "abgeschlossen", "Git & Versionskontrolle"));
        ln0103.put(2, new Leistungsnachweis(2, "LN02", "https://github.com/zilancavas/DevOps-02-Build", "hochgeladen", "55", "abgeschlossen", "Build Tools"));
        ln0103.put(3, new Leistungsnachweis(3, "LN03", "https://github.com/zilancavas/DevOps-03-DevOpsDemo", "offen", "0", "offen", "DevOpsDemo"));

        ln0406.put(1, new Leistungsnachweis(1, "LN04", "", "offen", "0", "offen", "Containers"));
        ln0406.put(2, new Leistungsnachweis(2, "LN05", "", "offen", "0", "offen", "Unit Tests"));
        ln0406.put(3, new Leistungsnachweis(3, "LN06", "", "offen", "0", "offen", "Quality"));

        ln0710.put(1, new Leistungsnachweis(1, "LN07", "", "offen", "0", "offen", "CI 1/2"));
        ln0710.put(2, new Leistungsnachweis(2, "LN08", "", "offen", "0", "offen", "CI 2/2"));
        ln0710.put(3, new Leistungsnachweis(3, "LN09", "", "offen", "0", "offen", "Docker Deployment"));
        ln0710.put(4, new Leistungsnachweis(4, "LN10", "", "offen", "0", "offen", "Cloud Deployment"));
    }

    @GetMapping("/services/leistungsnachweis0103")
    public List<PathListEntry<Integer>> getAll0103() { return toList(ln0103, "ln0103Key"); }
    @GetMapping("/services/leistungsnachweis0103/{key}")
    public Leistungsnachweis get0103(@PathVariable Integer key) { return ln0103.get(key); }
    @PostMapping("/services/leistungsnachweis0103")
    public void create0103(@RequestBody Leistungsnachweis e) {
        int id = ln0103.keySet().stream().max(Comparator.naturalOrder()).orElse(0) + 1;
        e.setId(id); ln0103.put(id, e);
    }
    @PutMapping("/services/leistungsnachweis0103/{key}")
    public void update0103(@PathVariable Integer key, @RequestBody Leistungsnachweis e) { e.setId(key); ln0103.put(key, e); }
    @DeleteMapping("/services/leistungsnachweis0103/{key}")
    public Leistungsnachweis delete0103(@PathVariable Integer key) { return ln0103.remove(key); }

    @GetMapping("/services/leistungsnachweis0406")
    public List<PathListEntry<Integer>> getAll0406() { return toList(ln0406, "ln0406Key"); }
    @GetMapping("/services/leistungsnachweis0406/{key}")
    public Leistungsnachweis get0406(@PathVariable Integer key) { return ln0406.get(key); }
    @PostMapping("/services/leistungsnachweis0406")
    public void create0406(@RequestBody Leistungsnachweis e) {
        int id = ln0406.keySet().stream().max(Comparator.naturalOrder()).orElse(0) + 1;
        e.setId(id); ln0406.put(id, e);
    }
    @PutMapping("/services/leistungsnachweis0406/{key}")
    public void update0406(@PathVariable Integer key, @RequestBody Leistungsnachweis e) { e.setId(key); ln0406.put(key, e); }
    @DeleteMapping("/services/leistungsnachweis0406/{key}")
    public Leistungsnachweis delete0406(@PathVariable Integer key) { return ln0406.remove(key); }

    @GetMapping("/services/leistungsnachweis0710")
    public List<PathListEntry<Integer>> getAll0710() { return toList(ln0710, "ln0710Key"); }
    @GetMapping("/services/leistungsnachweis0710/{key}")
    public Leistungsnachweis get0710(@PathVariable Integer key) { return ln0710.get(key); }
    @PostMapping("/services/leistungsnachweis0710")
    public void create0710(@RequestBody Leistungsnachweis e) {
        int id = ln0710.keySet().stream().max(Comparator.naturalOrder()).orElse(0) + 1;
        e.setId(id); ln0710.put(id, e);
    }
    @PutMapping("/services/leistungsnachweis0710/{key}")
    public void update0710(@PathVariable Integer key, @RequestBody Leistungsnachweis e) { e.setId(key); ln0710.put(key, e); }
    @DeleteMapping("/services/leistungsnachweis0710/{key}")
    public Leistungsnachweis delete0710(@PathVariable Integer key) { return ln0710.remove(key); }

    private List<PathListEntry<Integer>> toList(Map<Integer, Leistungsnachweis> map, String keyName) {
        var result = new ArrayList<PathListEntry<Integer>>();
        for (var e : map.values()) {
            var entry = new PathListEntry<Integer>();
            entry.setKey(e.getId(), keyName);
            entry.setName(e.getName());
            entry.getDetails().add(e.getScreencastStatus());
            entry.setTooltip(e.getKommentar());
            result.add(entry);
        }
        return result.stream().sorted(Comparator.comparing(PathListEntry::getName)).toList();
    }
}