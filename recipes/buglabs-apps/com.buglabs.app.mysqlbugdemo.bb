require bug-app.inc

DESCRIPTION = "This is a simple app  that interact with a   MySQL DB;  the  app storages  Button Event into a database and provides a servlet  to query the events. \
* Read *The How To* \
* You need to create the sample database before using the app.  You can use the *bugdemo.sql* script included in the app. \
* To access the query servlet just type in your browser http://[BUG_IP]/mysqlDemo\
\
Question, suggestion, and comments are welcome. "
HOMEPAGE = "http://buglabs.net/applications/mysqlBugDemo"

DEPENDS += "com.buglabs.osgi.http com.buglabs.osgi service-tracker com.sun.javax.servlet com.buglabs.common "

PV = "2"

SRC_LINK = "http://buglabs.net/program_version/download/1027"

APIVERSION = ""
