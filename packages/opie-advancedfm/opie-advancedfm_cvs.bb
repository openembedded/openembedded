DESCRIPTION = "Opie Advanced Filemanager"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
PV = "1.1.9+cvs-${CVSDATE}"
APPNAME = "advancedfm"
RDEPENDS = "opie-advancedfm-pics"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/apps/${APPNAME} \
           ${HANDHELDS_CVS};module=opie/pics \
           ${HANDHELDS_CVS};module=opie/apps"
S = "${WORKDIR}/${APPNAME}"

inherit opie

do_install() {
    install -d ${D}/${palmtopdir}/pics/${APPNAME}/
    install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}/${palmtopdir}/pics/${APPNAME}/
}

PACKAGES_prepend = "opie-advancedfm-pics "
FILES_opie-advancedfm-pics = "${palmtopdir}/pics/${APPNAME}/*.png"

