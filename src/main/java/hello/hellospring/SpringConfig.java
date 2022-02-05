package hello.hellospring;

import hello.hellospring.reposiroty.*;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;
    private final MybatisMapper mybatisMapper;

    @Autowired
    public SpringConfig(DataSource dataSource , MybatisMapper mybatisMapper) {

        this.dataSource = dataSource;
        this.mybatisMapper = mybatisMapper;
    }

    @Bean
    public MemberService memberService(){

        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
        return new JdbcTemplateMemberRepository(dataSource);
//        return new MybatisRepository(mybatisMapper);
    }
}
