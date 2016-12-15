#Hibernate Reverse Engineering via Ant

The _hibernate-reveng_ directory contains the artifacts to reverse engineer Hibernate entities using an Ant script.  No offense to MyEclipse but it sucks compared to command line.

##Set Up

> You must have Apache Maven (mvn) and Apache Ant (ant) installed on your local machine to continue. 

Before running the Ant script the Hibernate Tools JARs and dependencies must be configured.  This is done using the `pom.xml` Maven file.  This `pom.xml` simply downloads the dependencies to a local directory that is referenced by the `hibernate.reveng.lib` property in the `build.xml` file:

```
<property name="hibernate.reveng.lib" value="/some/local/directory" />
```

Run the Maven package target to download the Hibernate Tools dependencies from the `DAL` project `/hibernate-reveng/` directory:
 
```
$ mvn package -Ddownload.directory=/some/local/directory
```

The `/some/local/directory` will contain the dependent JARs.
 
##File Descriptions
Once you've downloaded the dependencies as described in the *Set Up* section, you can now reverse engineer from a database.  Note that the files in the `hibernate-reveng` directory have already been set up for the _ALS_ Schema:

*  `/hibernate-reveng/composite-key-reveng.sql` will generate the Hibernate Reverse Engineering table settings for a composite-key based table.
    
*  `/hibernate-reveng/single-key-reveng.sql` will generate the Hibernate Reverse Engineering table settings for a single key table.
    
*  `/hibernate-reveng/hibernate.reveng.cfg.xml` is a Hibernate configuration file that points to reverse engineering DB database.  Update the `connection.url`, `connection.password`, and `connection.username` accordingly.

*  `/hibernate-reveng/hibernate.reveng.xml` is the Hibernate Reverse Engineering settings file that contains the tables to be reverse-engineered and the column and key settings.  The output of either `composite-key-reveng.sql` or `single-key-reveng.sql` is pasted into this file.  Be sure to set the `<table-filter match-name="ALS_PREFERENCE_FEE_INFO" exclude="false"/>` table filters for the tables you want to include in the reverse engineer.
     
*  `/hibernate-reveng/fwpdao.ftl` is a custom Hibernate Tools template used to generate an FWP compliant DAO.
    

##Usage
Execute the `gen_hibernate` Ant target (from the `DAL` project root directory):

```
$ ant gen_hibernate -Dhibernate.reveng.lib=/some/local/directory
```

Note that the `/some/local/directory` is the Hibernate Tools classpath and was defined in the *Set Up* section above.

Once the ant script runs, it will place the generated artifacts in the `build/reveng` directory.  Copy the artifacts (entity, DAO, PK) to your project.  Be sure to copy the new classes from the `hibernate.reveng.cfg.xml` file to the proper `hibernate.cfg.xml` file in your project.



