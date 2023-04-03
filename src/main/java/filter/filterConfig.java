package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.UserModel;

public class filterConfig implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest rq = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;

//		System.out.println("jahahahh");
//		chain.doFilter(request, response);

		UserModel user = (UserModel) rq.getSession().getAttribute("user");

		String uri = rq.getRequestURI();

		if (user != null) {
			if (uri.startsWith("/Web_Lesson1/admin")) {
				if (user.getRoleModel().getName().equals("admin")) {
					chain.doFilter(request, response);
				} else {
					resp.sendRedirect(rq.getContextPath() + "/home");

				}
			} else if(uri.startsWith("/Web_Lesson1/login")) {
				resp.sendRedirect(rq.getContextPath() + "/home");
			}
			else {
				chain.doFilter(request, response);
			}
		}
		else {
			if (uri.startsWith("/Web_Lesson1/login")) {
				chain.doFilter(request, response);
			} else {
				resp.sendRedirect(rq.getContextPath() + "/login");
			}
		}

		//
	}

}
