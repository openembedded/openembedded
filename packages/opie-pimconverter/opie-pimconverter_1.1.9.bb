DESCRIPTION = "Opie PIM database converter"
SECTION = "opie/pim"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
RDEPENDS = "sqlite3 sqlite"

APPNAME = "opimconverter"


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/tools/pimconverter \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps"

S = "${WORKDIR}/pimconverter"
EXTRA_QMAKEVARS_POST += "TARGET=${APPNAME}"

inherit opie

# FILES bin/opimconverter pics/opimconverter/* apps/1Pim/opimconverter.desktop
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

