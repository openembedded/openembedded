DESCRIPTION = "Appearance settings dialog for the Opie environment"
SECTION = "opie/settings"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
DEPENDS = "libqtaux2"
PV = "1.1.8+cvs-${CVSDATE}"
APPNAME = "appearance"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/settings/appearance2 \
           ${HANDHELDS_CVS};module=opie/pics \
           ${HANDHELDS_CVS};module=opie/apps"

S = "${WORKDIR}/appearance2"

inherit opie

# FILES plugins/application/libappearance.so* bin/appearance apps/Settings/Appearance.desktop pics/appearance
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

