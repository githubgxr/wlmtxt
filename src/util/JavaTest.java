package util;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wlmtxt.Works.service.WorksService;
import com.wlmtxt.domain.DO.wlmtxt_user;
import com.wlmtxt.domain.DO.wlmtxt_works;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext*.xml" })
public class JavaTest {

	@Resource
	WorksService worksService;
	@Test
	public void testLike() {
		wlmtxt_user user = new wlmtxt_user();
		user.setUser_id(TeamUtil.getUuid());
		wlmtxt_works works = new wlmtxt_works();
		works.setWorks_id(TeamUtil.getUuid());
		try {
			worksService.likWorks(user, works);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
