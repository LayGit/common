package com.laylib.common.jdbc;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.mysql.jdbc.Statement;

public class JdbcMapperFactory {
	public static <T> RowMapper<T> buildRowMapper(final Class<T> cls)
	{
		RowMapper<T> rowMapper = new RowMapper<T>(){

			public T mapRow(ResultSet rs, int rowNum) throws SQLException {
				T obj = null;
				try {
					obj = cls.newInstance();

					for (int i = 0, len = rs.getMetaData().getColumnCount(); i < len; i++)
					{
						String fieldName = rs.getMetaData().getColumnName(i+1);
						Field field = cls.getDeclaredField(fieldName);
						field.setAccessible(true);
						Object val = rs.getObject(fieldName);
						if (val == null)
						{
							if (field.getType() == Integer.TYPE || field.getType() == Double.TYPE || field.getType() == Float.TYPE || field.getType() == Long.TYPE)
								val = 0;
							else
								val = "";
						}
						field.set(obj, val);
					}
					return obj;
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				} catch (NoSuchFieldException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				} 
			}
			
		};
		
		return rowMapper;
	}
	
	public static RowCallbackHandler buildRowCallback(final Object obj)
	{
		RowCallbackHandler handler = new RowCallbackHandler(){

			public void processRow(ResultSet rs) throws SQLException {
				if (rs != null)
				{
					Class cls = obj.getClass();
					try {
						for (int i = 0, len = rs.getMetaData().getColumnCount(); i < len; i++)
						{
							String fieldName = rs.getMetaData().getColumnName(i+1);
							Field field = cls.getDeclaredField(fieldName);
							field.setAccessible(true);
							Object val = rs.getObject(fieldName);
							if (val == null)
							{
								if (field.getType() == Integer.TYPE || field.getType() == Double.TYPE || field.getType() == Float.TYPE || field.getType() == Long.TYPE)
									val = 0;
								else
									val = "";
							}
							field.set(obj, val);
						}
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (NoSuchFieldException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		
		return handler;
	}
	
	public static PreparedStatementCreator getPSCreator(final String sql, final Object... args)
	{
		return new PreparedStatementCreator(){
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException{
                PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                for (int i = 0; i < args.length; i++)
                {
                	ps.setObject(i+1, args[i]);
                }
                return ps;
            }
        };
	}
}
