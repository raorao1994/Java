package com.raorao.ssm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	//���� Handler����֮ǰִ��
	//���������֤�������Ȩ
	//���������֤�������֤ͨ����ʾ��ǰ�û�û�е�½����Ҫ�˷������ز�������ִ��
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("ִ�������֤�������Ȩ");
		// TODO �Զ����ɵķ������
		//��ȡ�����url
		String url = request.getRequestURI();
		//�ж�url�Ƿ��ǹ��� ��ַ��ʵ��ʹ��ʱ������ ��ַ���������ļ��У�
		//���﹫����ַ�ǵ�½�ύ�ĵ�ַ
		if(url.indexOf("login.action")>=0){
			//������е�½�ύ������
			return true;
		}
				
		//�ж�session
		HttpSession session  = request.getSession();
		//��session��ȡ���û������Ϣ
		String username = (String) session.getAttribute("username");
				
		if(username != null){
			//��ݴ��ڣ�����
			return true;
		}
				
		//ִ�������ʾ�û������Ҫ��֤����ת��½ҳ��
		//request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
				
		//return false��ʾ���أ�������ִ��
		//return true��ʾ����

		return true;
	}
	
	//����Handler����֮�󣬷���modelAndView֮ǰִ��
	//Ӧ�ó�����modelAndView�����������õ�ģ������(����˵�����)�����ﴫ����ͼ��Ҳ����������ͳһָ����ͼ
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO �Զ����ɵķ������
		System.out.println("ִ��postHandle�����֤�������Ȩ");
		
	}
	
	//ִ��Handler���ִ�д˷���
	//Ӧ�ó�����ͳһ�쳣����ͳһ��־����
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO �Զ����ɵķ������
		System.out.println("ִ��afterCompletion�����֤�������Ȩ");
	}

}
