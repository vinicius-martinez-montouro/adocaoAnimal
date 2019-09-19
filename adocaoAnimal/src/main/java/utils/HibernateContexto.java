package utils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HibernateContexto implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		DaoFactory.getFabricaDeSessoes().close();
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		DaoFactory.getFabricaDeSessoes();
	}

}
