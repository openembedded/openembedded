DESCRIPTION = "A note taking program with basic draw tools"
SECTION = "opie/pim"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
DEPENDS = "libopiecore2 libopieui2 libqtaux2"
APPNAME = "drawpad"


S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES plugins/application/libdrawpad.so* bin/drawpad apps/1Pim/drawpad.desktop pics/drawpad
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

