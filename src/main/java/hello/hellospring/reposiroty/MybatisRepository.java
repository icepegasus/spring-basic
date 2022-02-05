package hello.hellospring.reposiroty;

import hello.hellospring.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class MybatisRepository implements MemberRepository{

    private final MybatisMapper mybatisMapper;

    @Autowired
    public MybatisRepository(MybatisMapper mybatisMapper) {
        this.mybatisMapper = mybatisMapper;
    }


    @Override
    public Member save(Member member) {

        mybatisMapper.save(member);
        Optional<Member> optionalMember = mybatisMapper.findByName(member.getName());
        Member rtnMember = optionalMember.get();
        member.setId(rtnMember.getId());

        return rtnMember;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return mybatisMapper.findById(id);
    }

    @Override
    public Optional<Member> findByName(String name) {
        return mybatisMapper.findByName(name);
    }

    @Override
    public List<Member> findAll() {
        return mybatisMapper.findAll();
    }
}
