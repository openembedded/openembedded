DESCRIPTION = "DocTab settings dialog for the Opie environment."
SECTION = "opie/settings"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"

APPNAME = "doctab"


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/settings/doctab \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics"

S = "${WORKDIR}/${APPNAME}"

inherit opie

# FILES plugins/application/libdoctab.so* bin/doctab apps/Settings/DocTab.desktop
do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

