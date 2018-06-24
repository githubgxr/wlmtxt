package wlmtxt;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wlmtxt.Works.dao.WorksDao;
import com.wlmtxt.Works.service.WorksService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext*.xml" })
public class MyTest {
	@Resource
	WorksService worksService;
	@Resource
	WorksDao worksDao;

	@Test
	public void ttttt() {

		worksService.collaborativeFilteringByUser("e9660cab-759b-4d84-a1f0-241c265b3e88");

	}

	@Test
	public void t22222222222222() {

		int n = 0;

		for (int i = 0; i < 5; i++) {
			n = (int) (Math.random() * 20);
			System.out.println(n);
		}

	}

	/*
	 * 
	 */
	public WorksService getWorksService() {
		return worksService;
	}

	public WorksDao getWorksDao() {
		return worksDao;
	}

	public void setWorksDao(WorksDao worksDao) {
		this.worksDao = worksDao;
	}

	public void setWorksService(WorksService worksService) {
		this.worksService = worksService;
	}

}
