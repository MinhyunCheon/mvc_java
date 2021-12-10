package ctrl;

import ctrl.util.Controller;
import service.BbsService;
import service.BbsServiceImpl;

public class WriteController implements Controller {
	// DI(Dependency Injection
	private BbsService service;
	
	public WriteController() {
		service = new BbsServiceImpl();
	}

	@Override
	public Object execute(Object obj) {
		System.out.println("Write Controller Execute");
		return service.insertSv(obj);
	}
	
}
