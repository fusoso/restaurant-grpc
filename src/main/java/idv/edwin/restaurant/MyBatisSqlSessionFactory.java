package idv.edwin.restaurant;

import java.io.InputStream;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisSqlSessionFactory {
	private final static String USERNAME = "${username}";
	private final static String PASSWORD = "${password}";

	public static SqlSessionFactory buildSqlSessionFactory() throws ClassNotFoundException {
//        DataSource dataSource
//                = new PooledDataSource("com.mysql.cj.jdbc.Driver",
//                "jdbc:mysql://localhost:3306/${db_name}?serverTimezone=UTC&useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull",
//                USERNAME,
//                PASSWORD);
//        Environment environment
//                = new Environment("Development", new JdbcTransactionFactory(), dataSource);
//
//        Configuration configuration = new Configuration(environment);
//        configuration.addMapper(FoodMapper.class);
//
//
//        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//        return builder.build(configuration);
		InputStream inputStream = null;
		try {
			ClassLoader classloader = Thread.currentThread().getContextClassLoader();
			inputStream = classloader.getResourceAsStream("mybatis-config.xml");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new SqlSessionFactoryBuilder().build(inputStream);
	}
}
