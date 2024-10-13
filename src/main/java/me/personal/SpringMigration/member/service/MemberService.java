package me.personal.SpringMigration.member.service;

import me.personal.SpringMigration.member.entity.Member;
import me.personal.SpringMigration.member.repository.MemberRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member getMember(Long id){
        return memberRepository.findById(id).orElseThrow(()-> new RuntimeException("No member with specified id"));
    }

    public Member findByEmail(String email){
        List<Member> resultList = memberRepository.findByEmail(email);
        if (resultList.isEmpty()){
            throw new RuntimeException("No member with specified email");
        }
        return resultList.get(0);
    }

    public List<Member> findAllOrderByName(){
        return memberRepository.findAllOrderedByName();
    }

    public Member create(Member member) {
        try {
            return memberRepository.save(member);
        }catch (DataIntegrityViolationException e){
            throw new RuntimeException("Email already in use");
        }
    }
}
