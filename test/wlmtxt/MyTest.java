package wlmtxt;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wlmtxt.Works.service.WorksService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext*.xml" })
public class MyTest {
	@Resource

	@Test
	public void ttttt() {

		System.out.println();
	}

	WorksService worksService;

	public WorksService getWorksService() {
		return worksService;
	}

	public void setWorksService(WorksService worksService) {
		this.worksService = worksService;
	}

}
