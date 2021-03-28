package com.crackbyte.utility;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy;

public class NamingStrategy extends SpringPhysicalNamingStrategy {

    /**
     * To persist table,column name in database.
     *
     * @param name
     * @param jdbcEnvironment
     * @return identifier
     */
    public Identifier save(Identifier name, JdbcEnvironment jdbcEnvironment) {
        if (name == null) {
            return null;
        }
        return getIdentifier(name.getText().replace('.', '_'), name.isQuoted(), jdbcEnvironment);
    }

    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        return save(name, jdbcEnvironment);
    }

}
