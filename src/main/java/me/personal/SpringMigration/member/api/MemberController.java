package me.personal.SpringMigration.member.api;


import jakarta.validation.Valid;
import me.personal.SpringMigration.member.entity.Member;
import me.personal.SpringMigration.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/rest")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping(value = "v0/members/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Member getMemberById(
            @PathVariable(name = "id")
            Long id) {
        return memberService.getMember(id);
    }

    @GetMapping(value = "v0/members", produces = MediaType.APPLICATION_JSON_VALUE)
    public Member getMemberByEmail(
            @RequestParam(name = "email")
            String email) {
        return memberService.findByEmail(email);
    }

    @GetMapping(value = "v0/members/order", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Member> getMembersOrderByName() {
        return memberService.findAllOrderByName();
    }

    @PostMapping(value = "v0/members")
    public Member createMember(@RequestBody @Valid Member member) {
        return memberService.create(member);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleException(Exception exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
