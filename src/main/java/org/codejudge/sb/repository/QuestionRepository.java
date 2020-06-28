package org.codejudge.sb.repository;

import org.codejudge.sb.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Long> {
    Optional<Question> findById(Long questionId);
}
