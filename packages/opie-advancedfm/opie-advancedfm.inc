DESCRIPTION = "Opie Advanced Filemanager"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
APPNAME = "advancedfm"
RDEPENDS = "opie-advancedfm-pics"

S = "${WORKDIR}/${APPNAME}"

inherit opie

do_install() {
    install -d ${D}${palmtopdir}/pics/${APPNAME}/
    install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

PACKAGES_prepend = "opie-advancedfm-pics "
FILES_opie-advancedfm-pics = "${palmtopdir}/pics/${APPNAME}/*.png"

