require bug-app.inc

DESCRIPTION = "I wrote this application in response to a users question on the forums: \
http://bugcommunity.com/forums/viewtopic.php?t=324 \
Andrew wanted to step outside the monolithic nature of OSGi, in that your application bundle is automatically started when your required resources become available.  In this application, I do some headless stuff (print the date to the console) and if I get an LCD Module (or the IModuleDisplay service), I print the date to the LCD module.  \
This is handy if I want an application that doesn't necessarily require a GUI, but if there's an LCD module, can use it if it likes..  In fact, I think I'm going to modify the TweetNTwitch app to just this for login credentials.\
\
--------------------------------------\
Please feel free to email me at john [at] buglabs.net for information. Or check out BUGLabs on IRC: irc://irc.freenode.net/buglabs ."
HOMEPAGE = "http://buglabs.net/applications/PickAndChooseServicesApp"

DEPENDS += "com.buglabs.bug.base com.buglabs.osgi com.buglabs.common service-tracker com.buglabs.bug.module.lcd "

PV = "1"

SRC_LINK = "http://buglabs.net/program_version/download/224"

APIVERSION = ""
