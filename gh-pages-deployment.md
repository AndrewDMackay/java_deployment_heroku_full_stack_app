[📹 Lesson Recording](https://youtu.be/ZrRsw45jezA)

# Creating a protfolio on GitHub Pages

A Portfolio site is a showcase that proves that you can do what you talk about in your resume. Rather than telling prospective employers about your skills, you can create a software developer portfolio to show them.

here we will talk through setting up a react portfolio app and deploying to GitHub pages.

## Step 1: Creating Your GitHub Repository

First step is to create the repo which will contain your website files. After logging into your GitHub account, click the button to create a new repository. You can call this repository whatever you want but make sure that you create your React app with the same name. Ensure the repo is public.

> Take a note of your GitHub username

## Step 2: Creating Your Initial React App

At this point, we won't be creating a fully-functioning React app. We just want to reach the stage where we can get our site online and you can build it out further later on. If you're familiar with React, you may already want to add a simple "under construction" notice, just in case anybody does come looking, and it's probably wise not to post your URL anywhere until you're completely happy with your work.

To initialise your React app, cd into whichever directory you want to work in on your computer and run

```bash
npx create-react-app <whatever-you-want-to-name-your-app>
```

## Step 3. Install GitHub Pages as a Dev-Dependency

Dependencies in React are reusable components created by developers which give you access to interesting libraries and functionality. In order for your site to work, you'll need to install gh-pages, which you can do by cd-ing into your React app and running

```bash
npm install gh-pages --save-dev
```

## Step 5: Update Your package.json File

When you initialise your app, you'll notice that a package.json file is automatically generated for you. This is a JSON file that is used to manage the project's dependencies, scripts, and versions. To make sure your website can deploy properly, there are three lines of code we'll need to add.

1. Add a Home Page
In the first section of the package.json file, add a homepage. This will match the honepage that GitHub pages will generate for you in the pattern `https://<username>.github.io/<repo-name>`:

```json
"homepage": "https://<username>.github.io/<repo-name>"
```

2. Add Predeploy
In the scripts section, add a predeploy:

```json
"predeploy": "npm run build"
```

3. Add Deploy
Also in the scripts section, add a deploy, like so:

```json
"deploy": "gh-pages -d build"
```

## Step 6: Push to GitHub
Once you've completed the above steps, you should push your changes to GitHub. To do so, you can run the following commands:

```bash
git init
git add .
git commit -m "first commit"
git branch -M main
git remote add origin <repository URL>
git push -u origin main
```

## Step 7: Deploy
Now it's time to get your app online! Simply run

```
npm run deploy
```

and the scripts you added to your package.json file should kick into action.

Step 8: Update Your Repository Settings
Go to settings in your repository and look at the GitHub Pages section. Underneath the Source heading, you should have the option to select which branch the site is being built from. If it isn't already change the branch to `gh-pages`. This way, your repository will know what files you want to use to build your website.


## Step 9: Celebrate Your Success in Building Your Website!!
Your site should now be available at `your-username.github.io/`. Sure, it's not quite a full-blown portfolio website yet, but you've done the hard work and now you can start on the fun part!



