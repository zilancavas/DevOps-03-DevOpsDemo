package ch.zhaw.iwi.zilan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Zilan")
public class ZilanItemController {

    @Autowired
    private ZilanItemRepository repository;

    // GET – Alle Einträge abrufen
    @GetMapping
    public List<ZilanItem> getAllItems() {
        return repository.findAll();
    }

    // POST – Neuen Eintrag erstellen
    @PostMapping
    public ZilanItem createItem(@RequestBody ZilanItem item) {
        return repository.save(item);
    }

    // PUT – Bestehenden Eintrag aktualisieren
    @PutMapping("/{id}")
    public ZilanItem updateItem(@PathVariable Long id, @RequestBody ZilanItem updatedItem) {
        ZilanItem item = repository.findById(id).orElseThrow();
        item.setName(updatedItem.getName());
        item.setBeschreibung(updatedItem.getBeschreibung());
        item.setStartDatum(updatedItem.getStartDatum());
        item.setEndDatum(updatedItem.getEndDatum());
        return repository.save(item);
    }

       // DELETE – Eintrag löschen
       @DeleteMapping("/{id}")
       public void deleteItem(@PathVariable Long id) {
           repository.deleteById(id);
       }
   }