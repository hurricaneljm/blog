package com.hurricane.future.blog.test;

import java.util.EnumSet;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.hbm2ddl.SchemaExport.Action;
import org.hibernate.tool.schema.TargetType;
import org.junit.Test;

public class TestHibernateSchema {
	@Test
	public void testSchemaExport() {
		StandardServiceRegistry build = new StandardServiceRegistryBuilder().configure().build();
		Metadata metadata = new MetadataSources(build).buildMetadata();
		SchemaExport schemaExport = new SchemaExport();
		schemaExport.execute(EnumSet.of(TargetType.STDOUT), Action.CREATE, metadata);
//		schemaExport.execute(EnumSet.of(TargetType.STDOUT), Action.DROP, metadata);
//		schemaExport.execute(EnumSet.of(TargetType.STDOUT), Action.BOTH, metadata);
	}
}
