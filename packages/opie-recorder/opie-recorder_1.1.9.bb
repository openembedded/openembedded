DESCRIPTION = "Audio sampling recorder"
SECTION = "opie/multimedia"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"

APPNAME = "opierec"
PV = "r1"

SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/multimedia/opierec \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps"

S = "${WORKDIR}/opierec"

inherit opie

# FILES bin/opierec pics/opierec apps/Applications/opierec.desktop
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

