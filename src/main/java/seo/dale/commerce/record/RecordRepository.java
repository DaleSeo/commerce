package seo.dale.commerce.record;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seo.dale.commerce.record.Record;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
}
