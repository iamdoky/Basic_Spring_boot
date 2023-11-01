package inflearn.mvc.basic.hello.repository;

import inflearn.mvc.basic.hello.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository memberRepository = new MemoryMemberRepository();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
        // TEST 서로 순서와 상관없이 의존관계 없이 설계 해야한다.
        // 테스트 이후 데이터를 클리어 해준다.
    }

    @Test
    @DisplayName("Test save Member method")
    void save() {
        Member member = new Member();
        member.setName("Spring");

        memberRepository.save(member);

        Member result = memberRepository.findById(member.getId()).get();
        // Assertions.assertEquals(member, result);
        assertThat(member).isEqualTo(result);
    }

    @Test
    @DisplayName("Test name 비교하기")
    void findByName() {
        Member member1 = new Member();
        member1.setName("java");
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("spring");
        memberRepository.save(member2);

        Member name = memberRepository.findByName(member1.getName()).get();
        assertThat(name).isEqualTo(member1);
    }

    @Test
    void findByAll() {
        Member member1 = new Member();
        member1.setName("java");
        memberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("spring");
        memberRepository.save(member2);

        List<Member> result = memberRepository.findAll();

        assertThat(result.size()).isEqualTo(2);

    }
}