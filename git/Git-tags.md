#Git Tag

Git **tag** is used to bookmark (label) a particular commit in a git repository. Tags serve as a marker for a milestone or version of software, which is easier to refer to than a commit.

##How to use tag

- List tags in a repository
```
$ git tag
v0.1
v1.0
v1.1
v2.0
v1_bug_fix
```
It also provide a option to list only interesting tags using a *pattern*, such as "v1.*".
```
$ git tag -l 'v1.*'
v1.0
v1.1
```

- Creating a tag

There are two types of tag. First is **annotated tag**, which contains additional information and a message. The second is **lightweight tag**, which doesn't contain additional information or message.  For tagging a release of software, you should use an annotated tag.

### Create an Annotated tag (with -a option)
```
$ git tag -a v1.0 -m 'released version 1.0'
```

-a -> annotate, value -> a tag

-m -> message, value -> message to note for this tag

### Create a Lightweight tag
```
$ git tag v1.0_light
```
Lightweight tags can't use -a, -s, or -m.

### Showing tag information

Annotated tag:
```
$ git show v1.0
tag v1.0
Tagger: Example Example <Example@ex.com>
Date:   Mon Jan 19 11:01:45 2014 +0700

released version 1.0

commit s09df798fdg69sdf9g8sd9f0h8sd09f
Author: Ex2 Example <Example2@ex.com>
Date:   Mon Jan 12 18:47:09 2014 +0700

    complete version 1!
```

Lightweight tag:
```
$ git show v1.0_light
commit s09df798fdg69sdf9g8sd9f0h8sd09f
Author: Ex2 Example <Example2@ex.com>
Date:   Mon Jan 12 18:47:09 2014 +0700

    complete version 1!
```

### Tag a previous commit 
Suppose you've already committed some new work.  How can you add a tag to an older revision?  Use this:
```
$ git tag -a v1.0 s09df79
```
Specify the start of the commit checksum ("s09df79") as argument to `tag`.  You can view the checksums using: "git log --pretty=oneline" or Bitbucket Commits history.

### Push a tag
```
$ git push origin v1.0
```
You need to specify the tag to push. Or you want to push all tag
```
$ git push origin --tags
```

### Checkout the code for a tag
```
$ git checkout v1.0
```
The above example checks out the code for the `v1.0` tag, but you can't modify it in git.
If you want to modify the tagged commit you must create a new branch.  In that case, use:
```
$ git checkout -b v1_bug_fix v1.0
```
This command creates a "v1_bug_fix" branch in repository with code starting at the v1.0 tag.

### Delete a tag
```
$ git tag -d beta_v1.0
```
This command deletes tag name "beta_v1.0".

## More Information
* [Tagging Basics](http://git-scm.com/book/en/v2/Git-Basics-Tagging) intro to tagging on [git-scm](http://git-scm.com).
* [tag command reference](http://git-scm.com/docs/git-tag) describes complete syntax of the `git tag` command.