# Deployment using Heroku

### Learning Objectives

- Know what Deployment is
- Explain some of the key features of Heroku
- Be able to deploy a java app in Heroku

# Introduction

### What is Deploying?

Deploying is like publishing. When authors are ready for their work to be seen by the world, they publish it. When web developers are ready to share their projects, they deploy to the World Wide Web. Deployment is when a project is packaged and shared on the Internet. Unlike publishing you can deploy as many times as required over the course of a software project.

### Why do we need Heroku

Heroku makes the processes of deploying apps as simple and straightforward as possible, so that developers can focus on what’s most important: building amazing apps that delight and engage clients.

## Tracking your app in Git

- Login to Heroku/ Create a Heroku account if you do not have one already.

Before you can deploy your app to Heroku, you need to initialise a local Git repository and commit your application code to it.

The following example demonstrates initialising a Git repository for an app that lives in the users directory:

```sh
  cd pirates_server
  git init
  git add .
  git commit -m "Initial commit"

```
Remove any reference to **h2 database** in the Java projects pom.xml and replace with the following:

```xml
//<!-- Pom.xml -->

  <dependency>
      <groupId>org.springframework.boot</groupId>   //modified
      <artifactId>spring-boot-starter-jdbc</artifactId>   //modified
  </dependency>

  <dependency>
      <groupId>org.postgresql</groupId>   //added
      <artifactId>postgresql</artifactId>   //added
  </dependency>
```

Change the application.properties file to following:


```
spring.datasource.driverClassName=org.postgresql.Driver   //modified
spring.datasource.maxActive=10                            //modified
spring.datasource.maxIdle=5                               //modified
spring.datasource.minIdle=2                               //modified
spring.datasource.initialSize=5                           //modified
spring.datasource.removeAbandoned=true                     //modified
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.properties.hibernate.enable_lazy_load_no_trans=true
server.servlet.context-path=/api
```
We are removing all references to H2. This will also stop any overloading from our database and manage our connections.

Create a new class called DatabaseConfig in your package.

```sh
touch DatabaseConfig
```
Inside your configuration class we need to ensure that Heroku will connect with Hikari.
 
 Hikari is a JDBC DataSource implementation that provides a connection pooling mechanism. Compared to other implementations, it promises to be lightweight and better performing.

 ```java
 package com.example.codeclan.pirateservice;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Value("${spring.datasource.url}")
    private String dbUrl;
    
    @Bean
    public DataSource dataSource(){
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(dbUrl);
        return new HikariDataSource(config);
    }
}
 ```

## To Create a new Heroku app

Firstly we have to ensure we have the Heroku CLI installed

```sh
brew tap heroku/brew && brew install heroku
```

*If this is not successful please try:*

```sh
curl https://cli-assets.heroku.com/install.sh | sh
```

The **"heroku create"** CLI command creates a new empty application on Heroku, along with an associated empty Git repository.

If you run this command from your app’s root directory, the empty Heroku Git repository is automatically set as a remote for your local repository.

```sh
heroku login
```

```sh
heroku create
```
We need to ensure that our Heroku app has the postgresql plugin enabled. To do this you use command:

```sh
heroku addons:create heroku-postgresql
```

You can use the git remote command to confirm that a remote named Heroku has been set for your app:

```sh
git remote -v

heroku  https://git.heroku.com/sunny-beach-12345.git    //fetch
heroku  https://git.heroku.com/sunny-beach-12345.git    //post
```

You can also see the databse URL.

```sh
heroku config
```

And the status of the database.

```sh
heroku pg
```

Heroku assigns a unique name for your application. We can change this to a more suitable name later in the lesson.

## For an existing Heroku app

If you have already created your Heroku app, you can add a remote to your local repository. All you need is your Heroku app’s name:

```sh
heroku git:remote -a sunny-beach-12345
set git remote heroku to https://git.heroku.com/sunny-beach-12345.git
```

## Renaming remotes
By default, the Heroku CLI names all of the Heroku remotes it creates for your app Heroku. You can rename your remotes with the git remote rename command:

```sh
git remote rename heroku jens-pirates-server
```
Renaming your Heroku remote can be handy if you have multiple Heroku apps that use the same codebase. In this case, each Heroku app has its own remote in your local repository.


## Deploy! :tada:

To deploy your app to Heroku, you use the git push command to push the code from your local repository’s main branch to your Heroku remote, like so:

```sh
git push heroku master
```

Use this same command whenever you want to deploy the latest committed version of your code to Heroku.

Note that Heroku only deploys code that you push to main. Pushing code to another branch of the Heroku remote has no effect.


## Additional Resources

https://devcenter.heroku.com/
