DESCRIPTION = "A Biff-like mailchecker"
SECTION = "opie/applets"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
DEPENDS = "libmailwrapper"

APPNAME = "mailapplet"


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/net/mail/taskbarapplet \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps"

S = "${WORKDIR}/taskbarapplet"

inherit opie

