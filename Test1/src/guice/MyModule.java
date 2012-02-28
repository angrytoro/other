package guice;

import javax.inject.Inject;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

public class MyModule extends AbstractModule{

//	Service service;
//	
//	@Inject
//	public void setService(Service service) {
//		this.service = service;
//	}

	static{
		System.out.println("sdf");
	}
	
	@Override
	protected void configure() {
//		bind(Service.class).to(ServiceImpl.class).in(Singleton.class);
//		bindConstant().annotatedWith(Names.named("post")).to(8080);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Injector inject = Guice.createInjector(new MyModule());
		Service service = inject.getInstance(Service.class);
		service.p("success");
	}
}
