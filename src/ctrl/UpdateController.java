package ctrl;

import ctrl.util.Controller;
import ctrl.util.ServiceFactory;
import service.BbsService;

public class UpdateController implements Controller {
	private BbsService service;
	
	public UpdateController() {
		service = ServiceFactory.getInstence().GetBean("bbs");
	}

	@Override
	public Object execute(Object obj) {
		System.out.println("Update Controller Execute");
		return service.updateSv(obj);
	}

}
