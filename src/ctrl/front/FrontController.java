package ctrl.front;

import ctrl.util.BeanFactory;

public class FrontController {
	private BeanFactory factory;
	
	public FrontController() {
		factory = BeanFactory.getInstence();
	}
	
	public Object requestProc(int number, Object obj) {
		return factory.GetBean(number).execute(obj);
	}
}
