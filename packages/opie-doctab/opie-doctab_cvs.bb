DESCRIPTION = "DocTab settings dialog for the Opie environment."
SECTION = "opie/settings"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
PV = "1.1.9+cvs-${CVSDATE}"
APPNAME = "doctab"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/settings/doctab \
           ${HANDHELDS_CVS};module=opie/apps \
           ${HANDHELDS_CVS};module=opie/pics"

S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES plugins/application/libdoctab.so* bin/doctab apps/Settings/DocTab.desktop
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

