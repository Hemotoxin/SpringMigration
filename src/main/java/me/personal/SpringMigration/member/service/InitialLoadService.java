package me.personal.SpringMigration.member.service;


import jakarta.annotation.PostConstruct;
import me.personal.SpringMigration.member.entity.Member;
import me.personal.SpringMigration.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InitialLoadService {

    private final MemberRepository memberRepository;

    public InitialLoadService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @PostConstruct
    @Transactional
    public void init() {
        // Load initial data
        Member m1 = new Member();
        m1.setEmail("john.doe@example.com");
        m1.setName("John");
        m1.setPhoneNumber("07212345678");

        Member m2 = new Member();
        m2.setEmail("harry.potter@example.com");
        m2.setName("Harry");
        m2.setPhoneNumber("07212345678");

        memberRepository.save(m1);
        memberRepository.save(m2);

    }
}
