package net.eisele.camel.cdi;

import javax.ejb.Startup;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.cdi.ContextName;

/**
 *
 * @author myfear
 */
@ApplicationScoped
@Startup
@ContextName("cdi-context")
public class HelloRouteBuilder extends RouteBuilder {

    @Inject
    HelloBean helloBean;

    @Override
    public void configure() throws Exception {
        from("direct:start").transform(body().prepend(helloBean.sayHello()).append(" user."));
    }
}
