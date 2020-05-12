package ecommerce.utility;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.RequestContext;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.context.webmvc.SpringWebMvcThymeleafRequestContext;

import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

import ecommerce.model.OrderDetail;
import ecommerce.model.Orders;

@Component
public class PdfGenerator {
	@Autowired
	private SpringTemplateEngine templateEngine;
	
	public File exportToPdfBox(RequestContext requestContext, HttpServletRequest request, String templatePath, String out) {
	    try (OutputStream os = new FileOutputStream(out)) {
	        // There are more options on the builder than shown below.
	        PdfRendererBuilder builder = new PdfRendererBuilder();
	        System.out.println(getHtmlString(requestContext, request, templatePath));
	        builder.withHtmlContent(getHtmlString(requestContext, request, templatePath), "file:");
	        builder.toStream(os);
	        builder.run();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return new File(out);
	}

	private String getHtmlString(RequestContext requestContext, HttpServletRequest request, String templatePath) {
	    try {
	        final Context ctx = new Context();
	        SpringWebMvcThymeleafRequestContext thymeleafRequestContext = new SpringWebMvcThymeleafRequestContext(requestContext, request);
	        ctx.setVariable("thymeleafRequestContext", thymeleafRequestContext);
	        Orders order = (Orders) requestContext.getModel().get("order");
	        ctx.setVariable("orders", order);
	        double total = 0;
	        for(OrderDetail od: order.getOrderDetail())
	        	total += od.getQty() * od.getProduct().getPrice();
	        ctx.setVariable("total", total);
	        return templateEngine.process(templatePath, ctx);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return null;
	}
}
