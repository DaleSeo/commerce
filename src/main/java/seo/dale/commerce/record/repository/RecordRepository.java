package seo.dale.commerce.record.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import seo.dale.commerce.record.model.Record;

@Repository
public interface RecordRepository extends JpaRepository<Record, Long> {
}
