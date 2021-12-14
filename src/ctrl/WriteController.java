package ctrl;

import ctrl.util.Controller;
import ctrl.util.ServiceFactory;
import service.BbsService;

public class WriteController implements Controller {
	// DI(Dependency Injection
	private BbsService service;
	
	public WriteController() {
		service = ServiceFactory.getInstence().GetBean("bbs");
	}

	@Override
	public Object execute(Object obj) {
		System.out.println("Write Controller Execute");
		return service.insertSv(obj);
	}
	
}
