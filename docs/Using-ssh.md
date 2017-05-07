== Using SSH Protocol with Git

When you "push" updates from your local repository to a remote
on Github or Bitbucket, it asks you to authenticate using 
a login and password.  Instead of this, you can create a
public-private ssh key-pair and give the public key to Github.

== How SSH Authentication Works

SSH uses a pair of *keys* to prove your identity.  
Each key-pair consists of a public key and a private key,
which are functionally related: the public key can decrypt 
messages that are encrypted with the private key, and vice versa.
But, its infeasible to uncover the private key by using just
the public key.

You *securely* store the private key on your machine, 
and give the public key to remote machines that you want to communicate 
with using SSH.  When you attempt to establish a connection,
the remote machine will ask you to encrypt a *challenge* using
your private key.  Your local machine uses your
private key to encrypt the challenge and send it back;
the remote host decrypts the challenge again with your public
key -- if it matches the original challenge, that proves your identity
(that is, it proves you possess the private key).

== Set-up your SSH home

By convention, SSH looks for a directory named `.ssh` in your home
directory.  That is, `$HOME/.ssh`.  On Linux, this directory should
be mode 700 (only you can access it). 

== Generating SSH keys

You can use the same keys for several hosts, so you
do not need to generate separate key pairs for each one.
There are several ways to generate SSH keys and also several
standard algorithms to choose from.  Commonly used algorithms
are 2048-bit RSA, DSA, and eliptic curves (ECDSA).

When you create an SSH key-pair, you may be asked for a comment
(some algorithms let you store a comment in the key file, which
is useful for remembering what the key is for or a password hint).

You will also be asked for a passphrase that is used to encrypt
the private key, for protection against theft.  
When you use an ssh key, you'll be asked for the same passphrase 
(once per session) in order to decrypt the private key.
Its OK to use the same passphrase for many ssh key-pairs.

Some ways to create an ssh key pair are:

1. `ssh-keygen` command.  At a command line prompt, type:
```
ssh-keygen

Enter file in which to save the key (/home/jim/.ssh/id_rsa): foobar
Enter passphrase: ******
Re-enter passphrarse: ******
Your identification (private key) is saved as /home/jim/.ssh/foobar
Your public key is saved as /home/jim/.ssh/foobar.pub
```
Your public key is `foobar.pub` and private key is `foobar`.

2. In Eclipse, choose **Window -> Preferences**.  
On the left side of the dialog choose General - Network Connections - SSH2.
Then (on right side of dialog) select the "Key Management" tab.
Here you add existing key-pairs to Eclipse or generate a new key-pair.
Click "Generate RSA Key...", enter a passphrase, then click "Save Private Key".
Eclipse will ask for a filename.  Be sure that you save the key in your `.ssh` directory. Eclipse also saves the public key by appending ".pub" onto your filename.

3. On Bitbucket.


**Note:**
When creating ssh keys, you should always use SSH version 2 protocol
which supports more up-to-date algorithms.  
If your software creates keys named `identity` and `identity.pub`,
its probably using SSH version 1, which is too old 
and may not be accepted by some servers.

