package ch.zhaw.iwi.zilan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZilanItemRepository extends JpaRepository<ZilanItem, Long> {
    
}
