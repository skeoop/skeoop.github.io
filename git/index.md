## Git Related Material

* Git Basics [class notes](git-basics) guidelines given in class, including .gitignore [PDF](Git-Basics.pdf), [PPT]([Git-Basics.ppt)
* [Git Aliases](aliases) how to create an alias for a git command, such as "git co" alias for "git checkout".
* Using Github [PDF](Using-Github.pdf), [PPT](Using-Github.ppt) some guidelines for this course
* Using Git [Submodules](submodule)
* [Suggested Reading and References](references)

## Github Flow

A git "workflow" for solo or team projects.  We will use this:

* [Github Flow Illustrated Guide](https://guides.github.com/introduction/flow/) and
* [Description on Githubflow.io](https://githubflow.github.io/). Step #5 -merge only after pull request review is important! 
* [Pull Request Tutorial](https://yangsu.github.io/pull-request-tutorial/) why and how to use pull requests.
* [Commenting on Pull Requests](https://help.github.com/en/articles/commenting-on-a-pull-request) - examples of providing feedback to a Pull Request.
* Slides on Pull Requests [PDF](Pull-Requests.pdf) [PPT](Pull-Requests.ppt)

### Branching and Merging

* [Branching and Merging][git-book-branching-and-merging] in online Git Book.  
* My [branch and merge](branch-and-merge) notes.
* Merge Practice (in class): [PDF](Merge-Practice.pdf), [PPT](Merge-Practice.ppt)
* [How to use local branches with remotes](https://www.freecodecamp.org/forum/t/push-a-new-local-branch-to-a-remote-git-repository-and-track-it-too/13222) article has good exmaple of working with branches, such as:
    - Push your local branch to remote (creates remote branch): `git push -u origin branch_name`
    - Create a local branch to track a remote: `git checkout -b branch_name origin/branch_name` (and maybe do a `git pull` to be sure your branch is up-to-date)
    - Rename (move) a branch: `git branch -m old_name new_name`

### Github and Continuous Integration

Github integrates with other cloud services, including CI servers and Heroku.
When you commit something to Github, it will notify the service that there is new code and the service (typically) will "pull" the new code.

You configure the services for want for each repository.

* [C.I. Integration with Github](ci-integration) my notes, incomplete
