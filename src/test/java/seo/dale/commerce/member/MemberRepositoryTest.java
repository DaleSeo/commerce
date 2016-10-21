package seo.dale.commerce.member;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;
import seo.dale.commerce.core.EntityFactory;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MemberRepositoryTest {

	@Autowired
	private MemberRepository repository;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void testFindByUsername() {
		Member saved = entityManager.persist(EntityFactory.newMember("guest", "1234", "guest@commerce.com"));
		Member found = repository.findByUsername("guest");

		assertThat(found.getId()).isEqualTo(saved.getId());

		found = repository.findByUsername("user");

		assertThat(found).isNull();
	}

}