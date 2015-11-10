package com.laylib.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

public class SqlUtil {
	
	public static String find(String table, String fields, String where, String order, String limit)
	{
		StringBuilder sbSql = new StringBuilder();
		sbSql.append("select ");
		
		// field
		if (fields == null)
			fields = "*";
		sbSql.append(fields);

        // table
		sbSql.append( " from " + table);

        //where
		if (where != null)
			sbSql.append(" where " + where);

        // order by
		if (order != null)
			sbSql.append(" order by " + order);

        // limit
        if (limit != null)
            sbSql.append(" limit " + limit);
        
        return sbSql.toString();
	}
	
	public static String update(String table, String set, String where, String order, String limit)
	{
		StringBuilder sbSql = new StringBuilder();
		sbSql.append("update ");
		sbSql.append(table);
		sbSql.append(" set ");
		sbSql.append(set);
		
		//where
		if (where != null)
			sbSql.append(" where " + where);

        // order by
		if (order != null)
			sbSql.append(" order by " + order);

        // limit
        if (limit != null)
            sbSql.append(" limit " + limit);
        
        return sbSql.toString();
	}
	
	public static String add(Map<String, Object> config)
	{
		return "";
	}
	
	public static String findAll(String table, String fields, String whereClause, String orderBy, int pageIndex, int pageSize)
	{
		int start =  (pageIndex - 1) * pageSize;
		fields = fields == null || StringUtils.isBlank(fields) ? "*" : fields;
		
		StringBuilder sbSql = new StringBuilder();
		sbSql.append("select ");
		sbSql.append(fields);
		sbSql.append(" from ");
		sbSql.append(table);
		
		if (whereClause != null && !StringUtils.isBlank(whereClause))
		{
			sbSql.append(" where ");
			sbSql.append(whereClause);
		}
		
		if (orderBy != null && !StringUtils.isBlank(orderBy))
		{
			sbSql.append(" order by ");
			sbSql.append(orderBy);
		}
		
		sbSql.append(" limit ");
		sbSql.append(start);
		sbSql.append(",");
		sbSql.append(pageSize);
		
		return sbSql.toString();
	}
	
	public static String findAllSenior(String table, String fields, String primaryKey, String whereClause, String orderBy, int pageIndex, int pageSize)
	{
		int start =  (pageIndex - 1) * pageSize;
		fields = fields == null || StringUtils.isBlank(fields) ? "*" : fields;
		
		StringBuilder sbSql = new StringBuilder();
		sbSql.append("select ");
		sbSql.append(fields);
		sbSql.append(" from ");
		sbSql.append(table);
		sbSql.append(" where ");
		
		if (whereClause != null && !StringUtils.isBlank(whereClause))
		{
			sbSql.append(whereClause);
			sbSql.append(" and ");
		}
		sbSql.append(primaryKey);
		sbSql.append(" >= (select ");
		sbSql.append(primaryKey);
		sbSql.append(" from ");
		sbSql.append(table);
		if (whereClause != null && !StringUtils.isBlank(whereClause))
		{
			sbSql.append(" where ");
			sbSql.append(whereClause);
		}
		
		if (orderBy != null && !StringUtils.isBlank(orderBy))
		{
			sbSql.append(" order by ");
			sbSql.append(orderBy);
		}
		
		sbSql.append(" limit ");
		sbSql.append(start);
		sbSql.append(",1)");
		
		if (orderBy != null && !StringUtils.isBlank(orderBy))
		{
			sbSql.append(" order by ");
			sbSql.append(orderBy);
		}
		
		sbSql.append(" limit ");
		sbSql.append(pageSize);
		
		return sbSql.toString();
	}
}
