# Deployment using Firebase

### Learning Objective

- Be able to deploy a React app in Firebase

# Introduction

### Why do we need Firebase

With Firebase, you can focus your time and attention on developing the best apps. Since the operations and internal functions are so solid, and taken care of by the Firebase interface, you can spend more time developing the high quality app that users are going to want to use.

### Set up Firebase project.

Login/Create a Firebase account.
Ensure that you have your node_modules folder setup using the command:

```sh
npm install
```
We don't need the node modules folder to appear in our repo. To stop them uploading we create a .gitignore file.

```sh
touch .gitignore
```

Inside the file add node modules

```sh
node_modules
```

### Setup your React app to use your Heroku back end


- Remove proxy from the package.json file.

- In the request file (located in the helpers folder) set up a base url pointing to your Heroku back end url. (i.e.: https://jenspirates.herokuapp.com/api/pirates)

- Change each fetch to concatenate the base url and the relative path from your app url:

```js

class Request {

  constructor(){
    this.baseUrl = "https://jenspirates.herokuapp.com" // added
  }

    get(url) {
      return fetch(this.baseUrl + url)	//modified
      .then((res) => res.json());
    }

    delete(url) {
      return fetch(this.base + url, {	//modified
        method: "DELETE",
        headers: {'Content-Type': 'application/json'}
      })
    }

    post(url, payload){
      return fetch(this.base + url, {	//modified
        method: "POST",
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(payload)
      })
    }

    patch(url, payload){
      return fetch(this.base + url, {	//modified
        method: "PATCH",
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify(payload)
      })
    }

}

export default Request;

```


### Firebase CLI

Firstly we have to ensure we have the firebase CLI installed:

```sh
npm install -g firebase-tools
```

### Initial Setup for Firebase app

We then have to run a few command on terminal to start our setup.

```sh
firebase login

firebase init
```

### Creating our Firebase app using Terminal

```sh
Select "Hosting: Configure and deploy Firebase Hosting sites" from the list supplied - Press Space to select features, then Enter to confirm your choices.

Select "Create a new project"

Type "build" as the public directory

Configure as a single-page app (rewrite all urls to /index.html)? "Yes"

Set up automatic builds and deploys with GitHub? "No"

(If it asks to Overwrite any files say "No")

```

### Creating a production build

We must build the project before we can deploy to firebase.

```sh
npm run build
```

## Deploy! :tada:


```sh
firebase deploy
```

## Conclusion

* There are many platforms that can be used to deploy apps. It is just finding one which suits your needs and budget.
* You can create your deployment projects on the respective websites or in your terminal - ensure you are in the correct folder of the hierarchy.

### Some other platforms worth checking out

- GitHub - https://docs.github.com/en/pages
- dockerhub - https://hub.docker.com/
- surge - https://surge.sh/


## Additional Resources
https://firebase.google.com/docs
