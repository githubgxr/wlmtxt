package wlmtxt;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wlmtxt.Works.service.WorksService;
import com.wlmtxt.domain.VO.MyWorksVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext*.xml" })
public class MyTest {
	@Resource
	WorksService worksService;

	@Test
	public void ttttt() {
		MyWorksVO myWorksVO = new MyWorksVO();

		System.out.println(worksService.getMyWorksVO("e9660cab-759b-4d84-a1f0-241c265b3e88", myWorksVO));
	}

	public WorksService getWorksService() {
		return worksService;
	}

	public void setWorksService(WorksService worksService) {
		this.worksService = worksService;
	}

}
