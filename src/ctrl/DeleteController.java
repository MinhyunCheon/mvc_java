package ctrl;

import ctrl.util.Controller;
import service.BbsService;
import service.BbsServiceImpl;

public class DeleteController implements Controller {
	private BbsService service;

	public DeleteController() {
		service = new BbsServiceImpl();
	}
	
	@Override
	public Object execute(Object obj) {
		return service.deleteSv(obj);
	}

}
