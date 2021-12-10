package ctrl.util;

import java.util.HashMap;
import java.util.Map;

import ctrl.DeleteController;
import ctrl.SelectController;
import ctrl.UpdateController;
import ctrl.WriteController;

// 1. insert, 2. update, 3. delete, 4. select all, 5. select
public class BeanFactory {
	private static BeanFactory instance;
	private Map<Integer, Controller> map;
	
	private BeanFactory() {
		map = new HashMap<>();
		map.put(1, new WriteController());
		map.put(2, new UpdateController());
		map.put(3, new DeleteController());
		map.put(4, new SelectController()); // 4, 5 통합
	}
	
	public synchronized static BeanFactory getInstence() {
		if(instance == null) instance = new BeanFactory();
		return instance;
	}
	
	public Controller GetBean(int number) {
		return map.get(number);
	}
}
