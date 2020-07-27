---
title: Git Review Questions

## 1. What is the command to create a branch named `dev-food`?



## 2. What is the command to find out what your current branch is?




## 3. Command to show **all** branches including remote ones?




## 4. What is command to switch working copy to `dev-food`?




## 5. You commit some files to `dev-food` and try to "push" them to Github, but it fails:

```
cmd>  git add pizza.py
cmd>  git commit -m "add a new food"
cmd>  git push
fatal:  The current branch dev-food has no upstream branch. 
```

Explain why the error and how to fix the problem.



### Add "origin" as remote and push dev-food all in one command



## 6. What are reasons to use a pull request? (choose all correct)

[ ] to announce the start of work on a new branch    
[ ] to request feedback    
[ ] to request help    
[ ] to post issues related to a specific branch   
[ ] request review before merging a branch    
[ ] request review after merging a branch   

## 7. After you open a Pull Request, what are some things the team might comment on? (select all correct answers)

[ ] Coding style    
[ ] Unit tests are missing some test cases or not covering the code    
[ ] Suggest some refactoring    
[ ] Defects in code or something you forgot to do    
[ ] Another way you might implement a feature   
[ ] Compliment you on your good work  

## 8. What is the *one* rule of Github Flow?



## 9. In Github Flow, in what order should you do each of these? (1,2,3...) 

This is the *minimal* order. In reality, some steps may be done many times.

  ____ Create a local branch for your work.    
  ____ Push your branch to Github.    
  ____ Merge your branch code into master.    
  ____ Merge master into your branch, then rebase master.    
  ____ Wait for team to review and approve your work.   
  ____ Open an issue on Github with the title "Merge Request".    
  ____ Implement and **test** the feature on your machine.    
  ____ Open a Pull Request for review.    


## More questions

* View the differences between working copy and most recent commit (HEAD).

* After adding a file to staging are (`git add foo`) you change your mind.  How to remove `foo` from the staging area?

* You delete or mess up a tracked file in your working copy.  What is the command to replace it with a new copy from the most recent commit in git?

* Why don't we commit Java `.class` files made from our source code?

* Why don't we commit a JAR file of our project?

* If we *do* want to upload (to Github) a JAR file of our project for others to use, what's a better way to do than committing it to the repo?
