package co.develhope.SpringRepositories02.repositories;

import co.develhope.SpringRepositories02.entities.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.Description;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Tania Ielpo
 */


@Transactional
@RepositoryRestResource(path = "repo-prog-languages", collectionResourceDescription =  @Description( "Repository for ProgrammingLanguage table"))

public interface LanguageRepository extends JpaRepository<Language,Long> {

    /**
     * Custom query to update only inventor field "USE GET REQUEST IN POSTMAN" (see attached Json)
     * ex. localhost:5050/repo-prog-languages/search/updateLanguageSetInventorForName/?inventor=Tania&name=Java
     * @param name of the language of which to change inventor
     * @param inventor name with which to change inventor
     * @return
     */
    @Modifying
    @Query(value = "update programming_language l set l.inventor = :inventor  where l.name = :name",
            nativeQuery = true)
    Integer updateLanguageSetInventorForName(@Param("name") String name,
                                             @Param("inventor") String inventor);
}