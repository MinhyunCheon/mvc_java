package ctrl;

import ctrl.util.Controller;
import service.BbsService;
import service.BbsServiceImpl;

public class UpdateController implements Controller {
	private BbsService service;
	
	public UpdateController() {
		service = new BbsServiceImpl();
	}

	@Override
	public Object execute(Object obj) {
		System.out.println("Update Controller Execute");
		return service.updateSv(obj);
	}

}
