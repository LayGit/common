package com.laylib.common.jdbc;

import com.laylib.common.utils.SpringUtil;

public class JdbcTemplateDao {
	protected JdbcTemplateImpl _manageTemplate;
	protected JdbcTemplateImpl _shikeTemplate;
	
	public JdbcTemplateDao()
	{
		_manageTemplate = (JdbcTemplateImpl)SpringUtil.getBean("manageTemplate");
		_shikeTemplate = (JdbcTemplateImpl)SpringUtil.getBean("shikeTemplate");
	}
	
	protected JdbcTemplateImpl getManageTemplate()
	{
		return _manageTemplate;
	}
	
	protected JdbcTemplateImpl getShikeTemplate()
	{
		return _shikeTemplate;
	}
}
