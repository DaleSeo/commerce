package seo.dale.commerce;

//import org.springframework.beans.factory.DisposableBean;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
//import org.springframework.session.web.http.HeaderHttpSessionStrategy;
//import org.springframework.session.web.http.HttpSessionStrategy;
//import redis.clients.jedis.Protocol;
//import redis.embedded.RedisServer;

//@Configuration
//@EnableRedisHttpSession
public class SessionConfig {

//	@Bean
//	public HttpSessionStrategy httpSessionStrategy() {
//		return new HeaderHttpSessionStrategy();
//	}
//
//	@Bean
//	public JedisConnectionFactory connectionFactory(EmbeddedRedisServerBean redisServer) {
//		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
//		jedisConnectionFactory.setHostName("localhost");
//		jedisConnectionFactory.setPort(6379);
//		return jedisConnectionFactory;
//	}
//
//	@Bean
//	public EmbeddedRedisServerBean redisServer() {
//		return new EmbeddedRedisServerBean();
//	}
//
//	class EmbeddedRedisServerBean implements InitializingBean, DisposableBean {
//
//		private RedisServer redisServer;
//
//		@Override
//		public void afterPropertiesSet() throws Exception {
//			redisServer = new RedisServer(Protocol.DEFAULT_PORT);
//			redisServer.start();
//		}
//
//		@Override
//		public void destroy() throws Exception {
//			if (redisServer != null) {
//				redisServer.stop();
//			}
//		}
//	}

}

