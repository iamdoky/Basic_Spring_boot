package inflearn.mvc.basic.hello.service;

import inflearn.mvc.basic.hello.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean
    MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
