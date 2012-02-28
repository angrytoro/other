package guice;

import com.google.inject.ImplementedBy;

@ImplementedBy(ServiceImpl.class)
public interface Service {

	void p(String str);
}
