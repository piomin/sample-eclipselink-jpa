package pl.piomin.services.jpa;

import org.eclipse.persistence.config.PersistenceUnitProperties;
import org.eclipse.persistence.logging.SessionLog;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableAutoConfiguration
public class JpaConfiguration extends JpaBaseConfiguration {

    JpaProperties properties;

    protected JpaConfiguration(DataSource dataSource,
							   JpaProperties properties,
							   ObjectProvider<JtaTransactionManager> jtaTransactionManager) {
        super(dataSource, properties, jtaTransactionManager);
    }

    @Override
    protected AbstractJpaVendorAdapter createJpaVendorAdapter() {
        return new EclipseLinkJpaVendorAdapter();
    }

    @Override
    protected Map<String, Object> getVendorProperties(DataSource dataSource) {
        HashMap<String, Object> map = new HashMap<>();
        map.put(PersistenceUnitProperties.WEAVING, InstrumentationLoadTimeWeaver.isInstrumentationAvailable() ? "true" : "static");
        map.put(PersistenceUnitProperties.DDL_GENERATION, "create-or-extend-tables");
        map.put(PersistenceUnitProperties.LOGGING_LEVEL, SessionLog.FINEST_LABEL);
        // TODO - detect why no privileges
//        map.put(PersistenceUnitProperties.DATABASE_EVENT_LISTENER, "org.eclipse.persistence.platform.database.oracle.dcn.OracleChangeNotificationListener");
        return map;
    }

}
