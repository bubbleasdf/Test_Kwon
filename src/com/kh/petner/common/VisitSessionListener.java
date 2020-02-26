package com.kh.petner.common;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import com.kh.petner.market.model.dao.VisitCountDao;
import com.kh.petner.market.model.vo.VisitCount;

/**
 * Application Lifecycle Listener implementation class VisitSessionListener
 *
 */
@WebListener
public class VisitSessionListener implements HttpSessionListener {

	@Override
public void sessionCreated(HttpSessionEvent sessionEve) {
        
        // 세션이 새로 생성되면 execute() 실행한다.
        if(sessionEve.getSession().isNew()){
            execute(sessionEve);
        }
    }

    private void execute(HttpSessionEvent sessionEve) 
    {
        VisitCountDao dao = VisitCountDao.getInstance();
        
        try {
            // 전체 방문자 수 증가
            dao.setTotalCount();
            
        } catch (Exception e) {
        }
    }



	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		
	}
	
}
