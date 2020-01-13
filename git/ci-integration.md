## Continuous Integration for Test Automation

What tips in PAD mention something like this?


## Example Projects

| Language  | Demo Project | C.I. Results Page (+)   |
|-----------|--------------|----------------------|
| Java      | [demo-ci](https://github.com/jbrucker/demo-ci) | [demo-ci](https://travis-ci.com/jbrucker/demo-ci) |
| Python    | [demo-pyci](https://github.com/jbrucker/demo-pyci) | [demo-pyci](https://travis-ci.com/jbrucker/demo-ci) |

(+) In the project README.md there is a link to the CI page and an icon showing results of the last build.

## Demo

Add some new code and new tests.  Commit it Github.

Within a minute or so, Travis will checkout and build/test the code.

## How To (General Steps)

1. Create an account on Travis CI and give it access to Github repo(s) where you want to use C.I.

2. Add a build script for build and dependency management.  This depends on the language and details of your project.  For Java, choices are Ant, Gradle, and Maven.

3. Verify on your local machine that you can use the build tool to build and test the project.

4. Create a `.travis.yml` file to describe your project and the steps to build and test it.

5. Add `.travis.yml` to Git and push to Github.


## How To (Details)

1. Login to [https://travis-ci.com][travis-ci] using your Github login.

2. Give Travis access to the repo(s) that you want to use CI, or give it access to all repos.
   * You can come back to this page later by going to your Github account [Settings page](https://github.com/settings/profile) and click [Applications](https://github.com/settings/installations).
   * Your Github settings -> [Applications](https://github.com/settings/installations) page also lets you review and revoke OAuth access that you have granted to other apps. 

Now you need to configure CI for a particular repository. CI uses a "webhook" to notify the CI server when there is a new commit.

1. Go to the repository's Settings page. Click on Integrations and verify that Travis CI is an "Installed Github App".
2. On [Travis CI][travis-ci] go to the page listing your integrated Github repositories. To the right of each repo is a "Settings" button.
3. Use the Travis "Settings" page

## Notes

1. Github has deprecated the "services" interface, so don't use that. Use "apps" instead.  Travis-CI does this.

2. Use travis-ci.com, not travis-ci.org (old site for open source projects).

## References

[travis-ci]: https://travis-ci.com "Travis CI"

[travis-getting-started]: https://docs.travis-ci.com/user/getting-started/ "Travis CI Getting Started guide"

[travis-github-howto]: https://github.com/mbonaci/mbo-storm/wiki/Integrate-Travis-CI-with-your-GitHub-repo "Integrate Travis CI with your GitHub repo (basic instructions)"
