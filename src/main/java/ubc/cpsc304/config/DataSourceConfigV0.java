// package ubc.cpsc304.config;//package ubc.cpsc304.config;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@RequiredArgsConstructor
//public class DataSourceConfig {
//    final private DataSourceProps dataSourceProps;
//
//    @Bean
//    public DataSource getDataSource() {
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName(dataSourceProps.getDriverClassName());
//        dataSourceBuilder.url(dataSourceProps.getUrl());
//        dataSourceBuilder.username(dataSourceProps.getUsername());
//        dataSourceBuilder.password(dataSourceProps.getPassword());
//        return dataSourceBuilder.build();
//    }
//}
