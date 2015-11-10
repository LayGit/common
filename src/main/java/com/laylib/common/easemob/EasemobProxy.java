package com.laylib.common.easemob;

import org.jboss.resteasy.logging.Logger;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.laylib.common.easemob.comm.Constants;
import com.laylib.common.easemob.comm.HTTPMethod;
import com.laylib.common.easemob.comm.Roles;
import com.laylib.common.easemob.httpclient.utils.HTTPClientUtils;
import com.laylib.common.easemob.httpclient.vo.ClientSecretCredential;
import com.laylib.common.easemob.httpclient.vo.Credential;
import com.laylib.common.easemob.httpclient.vo.EndPoints;
import com.laylib.common.easemob.message.NotifyMessage;

public class EasemobProxy {
	private static final Logger LOGGER = Logger.getLogger(EasemobProxy.class);
	private static final JsonNodeFactory factory = new JsonNodeFactory(false);
	private static final String APPKEY = Constants.APPKEY;
	// 通过app的client_id和client_secret来获取app管理员token
    private static Credential credential = new ClientSecretCredential(Constants.APP_CLIENT_ID,
            Constants.APP_CLIENT_SECRET, Roles.USER_ROLE_APPADMIN);
	
	public static void sendNotify(NotifyMessage notifyMessage)
	{
		ObjectNode objectNode = factory.objectNode();
		try {
			objectNode = HTTPClientUtils.sendHTTPRequest(EndPoints.MESSAGES_URL, credential, JSON.toJSONString(notifyMessage),
					HTTPMethod.METHOD_POST);
			System.out.println(objectNode.toString());
			objectNode = (ObjectNode) objectNode.get("data");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
