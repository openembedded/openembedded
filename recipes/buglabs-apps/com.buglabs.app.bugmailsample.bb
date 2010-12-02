require bug-app.inc

DESCRIPTION = "h5. Notes\
* The Demo uses sockets instead JavaMail API to send emails.  \
* This app is intended to be used with a mail server without authentication (See tutorial).   \
* It doesn't work with the Virtual Bug\
Take a look at  this tutorial on how to install postfix on your bug. "
HOMEPAGE = "http://buglabs.net/applications/BugMailSample"

DEPENDS += "service-tracker com.buglabs.osgi.http com.buglabs.osgi.cm com.sun.javax.servlet com.buglabs.common com.buglabs.osgi com.buglabs.bug.module.lcd "

PV = "2"

SRC_LINK = "http://buglabs.net/program_version/download/862"

APIVERSION = "1.4"

BROKEN = "1"
