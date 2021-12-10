package ctrl;

import ctrl.util.Controller;
import service.BbsService;
import service.BbsServiceImpl;

public class SelectController implements Controller {
	private BbsService service;

	public SelectController() {
		service = new BbsServiceImpl();
	}
	
	@Override
	public Object execute(Object obj) {
		if(obj == null) return service.selectSv();
		return service.selectSv(obj);
	}

}
