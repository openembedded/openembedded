require bug-app.inc

DESCRIPTION = "*OVERVIEW*\
We all some time put print statement in our code for the sole purpose of knowing if another statement is executed or not.\
debug purpose i should say. but what happens when the code is a few miles long ?\
what about when everything is 'OK' and you want to remove all the print statement in the code?\
even better, what if you still want some of these print statement to still be displayed in the event of errors .\
I know the bug already have Concierge as a logging service but log4j can also be used on top of concierge to\
provide logging flexibility to your applications.\
The main feature of log4j that I like is the ability to turn off certain logs or all of them if you'd like.\
for example, when the product is ready for retail i could just enable logs at the ERROR and FATAL level.\
This app is really the same as SimpleGame ( my first application). the only difference is that i have added log4j to the code to show how it can be done. You will also notice that I also cover chainsaw in this example.\
chainsaw is used in conjunction with log4j to allow viewing logs from multiples application on multiple remote machines at the same time.\
in order to use the chainsaw viewer you will need to download the following \
http://logging.apache.org/log4j/docs/webstart/chainsaw/chainsaw-bundle.zip\
*HOW IT WORKS*\
run the app and you will see logs i the console window as you play the SimpleGame\
another copy of the same log is kept in /home/root/out.log on the physical bug\
a copy is also sent to chainsaw for remote viewing in this case to 127.0.0.1 ( localhost)\
*SETTING UP THE LOG VIEWER*\
* unzip the file\
* locate chainsaw.sh\
* make it executable\
* run ./chainsaw.sh from the console\
*MORE ON CHAINSAW*\
please refer to :\
http://community.buglabs.net/switch/posts/146-Chainsaw-HOWTO\
to learn more about ChainSaw.\
\
_for more reading:\
http://logging.apache.org/log4j/1.2/index.html\
http://logging.apache.org/chainsaw/index.html_"
HOMEPAGE = "http://buglabs.net/applications/log4jExample"

DEPENDS += "com.buglabs.osgi com.buglabs.common service-tracker com.buglabs.bug.module.lcd "

PV = "8"

SRC_LINK = "http://buglabs.net/program_version/download/895"

APIVERSION = "1.4"

BROKEN = "1"
