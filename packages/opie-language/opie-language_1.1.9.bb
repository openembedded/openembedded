DESCRIPTION = "Language settings dialog"
SECTION = "opie/settings"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"

APPNAME = "language"


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/settings/language \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps"

S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES plugins/application/liblanguage.so* bin/language apps/Settings/Language.desktop

