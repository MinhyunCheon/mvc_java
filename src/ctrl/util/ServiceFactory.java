package ctrl.util;

import java.util.HashMap;
import java.util.Map;

import service.BbsService;
import service.BbsServiceImpl;

public class ServiceFactory {
	private static ServiceFactory instance;
	private Map<String, BbsService> map;
	
	private ServiceFactory() {
		map = new HashMap<>();
		map.put("bbs", new BbsServiceImpl());
	}
	
	public synchronized static ServiceFactory getInstence() {
		if(instance == null) instance = new ServiceFactory();
		return instance;
	}
	
	public BbsService GetBean(String serviceName) {
		return map.get(serviceName);
	}
}
