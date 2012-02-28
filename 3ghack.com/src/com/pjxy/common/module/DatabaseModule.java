package com.pjxy.common.module;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.guice.MyBatisModule;
import org.mybatis.guice.datasource.builtin.PooledDataSourceProvider;
import org.mybatis.guice.datasource.helper.JdbcHelper;

import com.google.inject.name.Names;

public class DatabaseModule extends MyBatisModule {

	@Override
	protected void initialize() {
		install(JdbcHelper.MySQL);
		bindDataSourceProviderType(PooledDataSourceProvider.class);
		bindTransactionFactoryType(JdbcTransactionFactory.class);
		Names.bindProperties(binder(), createTestProperties());
		addMapperClasses("com.pjxy.common.dao");
	}

	private Properties createTestProperties() {
		Properties myBatisProperties = new Properties();
		try {
			myBatisProperties.load(new FileInputStream(new File(
					"C:\\mybatis.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return myBatisProperties;
	}
}
