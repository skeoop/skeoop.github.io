---
title: Aliases for Git Commands
---

You can define your own aliases for Git commands,
and some of the git commands you use regularly may
already be aliases!

On Linux there is a built-in alias "history", but Windows users don't have this.
`git history` is very useful so you might want to add this to your own git config.

## Viewing Git Aliases

Type:
```
> git config --list
```
the output will look something like this:
```
user.name=fatalaijon
user.email=fatalaijon@gmail.com
push.default=simple
alias.log1=log --graph --abbrev-commit --decorate --date=relative --format=format:'%C(bold blue)%h%C(reset) - %C(bold green)(%ar)%C(reset) %C(white)%s%C(reset) %C(dim white)- %an%C(reset)%C(bold yellow)%d%C(reset)' --all
alias.log2=log --graph --abbrev-commit --decorate --format=format:'%C(bold blue)%h%C(reset) - %C(bold cyan)%aD%C(reset) %C(bold green)(%ar)%C(reset)%C(bold yellow)%d%C(reset)%n''          %C(white)%s%C(reset) %C(dim white)- %an%C(reset)' --all
alias.history=!git log1
merge.tool=/usr/bin/diffuse
```

The lines beginning with "alias." are aliases.  Here, "log1", "log2", and "history" are aliases, so I can type:
```
git log1
```

## Create aliases with `git config`

Suppose you want to type "git c" as an alias for "git commit".
Create an alias using:
```
> git config --global alias.c commit
```

This adds `alias.c` to your global configuration, with value "commit".  
Now you can commit files by typing:
```
> git c -m "your commit message"
```

If you don't write `--global` then the setting only applies to the current project.

### Practice:  Subversion Envy "svn co"

Subversion (svn) has "co" as a synonym for "checkout", so to checkout a branch:
```
> svn co branch_name
```

How to add this handy alias  to git? So we can type:
```
> git co branch_name
```

## Create Aliases Directly in .gitconfig

Your global configuration information is stored in file `.gitconfig` in your home directory.  You can edit this file directly. Be careful not to screw up, of course.  The files is divided into sections, with `[aliases]` being one section.

Here is an example, including the "c" alias:
```
[alias]
c = commit
log1 = log --graph --abbrev-commit --decorate --date=relative --format=format:'%C(bold blue)%h%C(reset) - %C(bold green)(%ar)%C(reset) %C(white)%s%C(reset) %C(dim white)- %an%C(reset)%C(bold yellow)%d%C(reset)' --all
history = !"git log1"
```

This shows that "history" is itself an alias for another alias (log1).  You could directly define "history" as alias using the same value as the "log1" alias.


## Git Alias versus Shell Alias

The Windows command shell, PowerShell, and all the
Linux shells (such as bash) all have a way to define
aliases.  Don't confuse them with git aliases.

Example: I use "git status -s" (short output) a lot.
I also use "git commit" a lot, so I have bash aliases
for these commands in my `.bashrc` file:
```
alias gs="git status -s"
alias commit="git commit"
```

Now I can just type:
```
(check status)
> gs
M  README.md
M  src/tictactoe/Board.java
(commit files)
> commit -m "Modify board to ..."
```

Since its the command shell that interprets and processes
the "gs" and "commit", they are shell aliases. 

## Reference

[How to Create Git Aliases](https://mijingo.com/blog/how-to-create-git-aliases) by Ryan Irelan.
