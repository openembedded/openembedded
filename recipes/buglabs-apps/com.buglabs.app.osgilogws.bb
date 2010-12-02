require bug-app.inc

DESCRIPTION = "App to expose the OSGi log as a web service.\
After launching Virtual BUG and loading app, go here:\
http://localhost:8082/service/LogViewer\
This is the first step in exposing the OSGi backend as a web service.  While it's redundant for the Virtual BUG, it's convenient for the physical BUG.   Eventually I hope to allow users to configure the OSGi runtime from their browser.\
Room for extensions:  log4j or ops4j bundles to extend the log to XML for easy parsing and debugging.  Right now it's just plain text.  Perhps in lieu of functionality,  I may doll up the plain-text output as html.\
Plans for future versions: expose the IShellCommandExecutor as a web service, with a console-like WS.  maybe all web 2.0 with an XMLResponse Servlet a la ajax.\
\
"
HOMEPAGE = "http://buglabs.net/applications/OSGiLogWS"

DEPENDS += "com.buglabs.osgi service-tracker com.buglabs.common "

PV = "1"

SRC_LINK = "http://buglabs.net/program_version/download/139"

APIVERSION = ""
