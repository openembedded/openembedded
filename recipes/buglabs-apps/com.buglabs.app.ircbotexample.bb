require bug-app.inc

DESCRIPTION = "This is an app used on motherbug to show how to use the PIRC API and motion detector.  Drop into #buglabs on irc.freenode.net and just say 'time' and you'll see the last time motherbug detected motion."
HOMEPAGE = "http://buglabs.net/applications/IRCBotExample"

DEPENDS += "service-tracker com.buglabs.bug.module.motion com.buglabs.common com.buglabs.bug.module.vonhippel com.buglabs.bug.base com.buglabs.osgi "

PV = "7"

SRC_LINK = "http://buglabs.net/program_version/download/909"

APIVERSION = ""

BROKEN = "1"
