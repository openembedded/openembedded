require bug-app.inc

DESCRIPTION = "*Version 1*\
This example show how to combine bug modules and http service .  When the service accessed ,  it returns a html page with a picture taken by the camera module. To access the service: \
* On the virtual bug http://localhost:8082/RemoteCamera\
* On the bug http://10.10.10.10/RemoteCamera\
"
HOMEPAGE = "http://buglabs.net/applications/RemoteCamera"

DEPENDS += "service-tracker com.buglabs.osgi.http com.buglabs.bug.module.camera com.sun.javax.servlet com.buglabs.common com.buglabs.osgi "

PV = "1"

SRC_LINK = "http://buglabs.net/program_version/download/503"

APIVERSION = ""

BROKEN = "1"
