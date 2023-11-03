package inflearn.mvc.basic.hello.service;

import inflearn.mvc.basic.hello.domain.Member;
import inflearn.mvc.basic.hello.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) { 
        this.memberRepository = memberRepository;
    }


    // Sign Up
    public Long join(Member member) {
        // Member duplicate name check
        validateDuplicateMember(member);

        return memberRepository.save(member)
                .getId();
    }

    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 member name");
                });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
