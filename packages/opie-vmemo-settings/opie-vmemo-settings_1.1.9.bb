DESCRIPTION = "Sound settings dialog"
SECTION = "opie/settings"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"

APPNAME = "sound"


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/settings/sound \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps"

S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES plugins/application/libsound.so* bin/sound apps/Settings/Sound.desktop
