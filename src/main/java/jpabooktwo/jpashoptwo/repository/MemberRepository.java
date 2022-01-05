package jpabooktwo.jpashoptwo.repository;

import jpabooktwo.jpashoptwo.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository //컴포넌트 스캔으로 스프링 빈에 등록해주는 어노테이션
@RequiredArgsConstructor   //@PersistenceContext 기능도 자동으로 생성(단 final이 붙은 필드에 한해서)
public class MemberRepository {

//    @PersistenceContext //EntityManager를 사용할 수 있도록 해주는 어노테이션
    private final EntityManager em;

    public void save(Member member){
        em.persist(member);
    }

    public Member findOne(Long id){
        return em.find(Member.class, id);
    }

    public List<Member> findAll(){
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }

    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
