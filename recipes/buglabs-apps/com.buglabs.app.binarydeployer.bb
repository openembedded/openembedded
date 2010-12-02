require bug-app.inc

DESCRIPTION = "Proof of Concept for deploying binary applications using a BUG App.\
This particular application deploys a binary of fbgrab into the /usr/bin directory.  fbgrab is what allows the motherbug to provide the screenshot service:\
http://motherbug1.buglabs.net/service/ScreenShot\
I'm hoping we'll be using something like this for patches.  To use this yourself, create a tarball of the files you'd like untarred onto the bug and place the tarball into your workspace/BinaryDeployer/binary folder.  Send the app to your BUG and wham, you're good. Right now the Rootfs tarball will crash the SDK if you try to upload something of that size onto the bug (toooo baaad), but this may change in future SDK releases.\
 \
"
HOMEPAGE = "http://buglabs.net/applications/BinaryDeployer"

PV = "1"

SRC_LINK = "http://buglabs.net/program_version/download/245"

APIVERSION = ""
