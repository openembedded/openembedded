DESCRIPTION = "Mail plugin for Today"
SECTION = "opie/today"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
DEPENDS = "opie-today opie-mailapplet"
RDEPENDS = "opie-today opie-mailapplet"

APPNAME = "todaymailplugin"


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/core/pim/today/plugins/mail "

S = "${WORKDIR}/mail"

inherit opie
