package ctrl;

import ctrl.util.Controller;
import ctrl.util.ServiceFactory;
import service.BbsService;

public class DeleteController implements Controller {
	private BbsService service;

	public DeleteController() {
		service = ServiceFactory.getInstence().GetBean("bbs");
	}
	
	@Override
	public Object execute(Object obj) {
		return service.deleteSv(obj);
	}

}
