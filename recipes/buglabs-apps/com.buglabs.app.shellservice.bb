require bug-app.inc

DESCRIPTION = "A OSGi service for executing commands on the shell.\
A IShellService provides an IShellSession.  This session is used just like a terminal session; in fact it is one.  Commands can be executed, environment variables can be set.  Be careful, this service is very powerful!"
HOMEPAGE = "http://buglabs.net/applications/ShellService"

DEPENDS += "com.buglabs.common "

PV = "3"

SRC_LINK = "http://buglabs.net/program_version/download/1001"

APIVERSION = ""
