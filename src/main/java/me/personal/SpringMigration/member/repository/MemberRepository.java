package me.personal.SpringMigration.member.repository;

import me.personal.SpringMigration.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("select m from Member m where m.email = ?1")
    List<Member> findByEmail(String emailAddress);

    @Query(value = "SELECT * FROM Member m ORDER BY name", nativeQuery = true)
    List<Member> findAllOrderedByName();

}
