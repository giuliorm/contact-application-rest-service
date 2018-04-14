package ru.juriasan.clientrequestservice.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.juriasan.clientrequestservice.domain.Application;

import java.util.List;

@Repository
public interface ApplicationRepository extends CrudRepository<Application, Long> {

    List<Application> findAll();
    @Query(value =
            "select * " +
            "from application " +
            "inner join (" +
                    "select max(dt_created) as maxDate " +
                    "from application " +
                    "where contact_id = ?1) " +
                    "as m " +
            "on dt_created = m.maxDate " +
            "order by application_id desc " +
            "limit 1;", nativeQuery = true)
    Application latest(long contactId);
}
