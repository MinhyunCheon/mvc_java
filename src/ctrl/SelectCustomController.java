package ctrl;

import ctrl.util.Controller;
import ctrl.util.ServiceFactory;
import service.BbsService;

public class SelectCustomController implements Controller {
	private BbsService service;
	
	public SelectCustomController() {
		service = ServiceFactory.getInstence().GetBean("bbs");
	}

	@Override
	public Object execute(Object obj) {
		System.out.println("Select Custom Controller Execute");
		return service.selectCustomSv(obj);
	}

}
