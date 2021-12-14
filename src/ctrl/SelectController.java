package ctrl;

import ctrl.util.Controller;
import ctrl.util.ServiceFactory;
import service.BbsService;

public class SelectController implements Controller {
	private BbsService service;

	public SelectController() {
		service = ServiceFactory.getInstence().GetBean("bbs");
	}
	
	@Override
	public Object execute(Object obj) {
		if(obj == null) return service.selectSv();
		return service.selectSv(obj);
	}

}
