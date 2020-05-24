package com.ats.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class SessionListener implements HttpSessionAttributeListener {

	@Override
	public void attributeAdded(HttpSessionBindingEvent hsbe) {
		// TODO Auto-generated method stub

	}

	@SuppressWarnings("unused")
	@Override
	public void attributeRemoved(HttpSessionBindingEvent hsbe) {
		String name = hsbe.getName();
		HttpSession session = hsbe.getSession();
		if ("nickname".equalsIgnoreCase(name))
		{
			String nickname = (String)hsbe.getValue();
			if (nickname != null)
			{
				ServletContext application = session.getServletContext();
				if (application != null)
				{
					Object o = application.getAttribute("chatroomlist");		
					if (o != null)
					{
						ChatRoomList roomList = (ChatRoomList)o;
						ChatRoom room = roomList.getRoomOfChatter(nickname);
						if (room != null)
						{
							Object chatter = room.removeChatter(nickname);
							if (chatter != null)
							{
								String n = ((Chatter)chatter).getName();
							}
							
						}
					}
				}
				else
				{
					System.out.println("ServletContext is null");
				}					
			}
		}		

	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent hsbe) {
		// TODO Auto-generated method stub

	}

}
