package hello.hellospring.reposiroty;

import hello.hellospring.domain.Member;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Optional;

@Mapper
public interface MybatisMapper {


    @Insert("insert into member (name) values (#{name})")
    void save(Member member);

    @Select("SELECT * FROM member where id = #{id}")
    Optional<Member> findById(Long id);

    @Select("SELECT * FROM member where name = #{name}")
    Optional<Member> findByName(String name);

    @Select("SELECT * FROM member")
    List<Member> findAll();

}
