DESCRIPTION = "Audio sampling recorder"
SECTION = "opie/multimedia"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
PV = "1.1.8+cvs-${CVSDATE}"
APPNAME = "opierec"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/multimedia/opierec \
           ${HANDHELDS_CVS};module=opie/pics \
           ${HANDHELDS_CVS};module=opie/apps"

S = "${WORKDIR}/opierec"

inherit opie

# FILES bin/opierec pics/opierec apps/Applications/opierec.desktop
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

