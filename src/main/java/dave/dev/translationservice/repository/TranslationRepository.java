package dave.dev.translationservice.repository;

import dave.dev.translationservice.model.Translation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TranslationRepository extends JpaRepository<Translation,Long> {
}