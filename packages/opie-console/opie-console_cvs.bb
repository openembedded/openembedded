DESCRIPTION = "Console Application"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
PV = "1.1.9+cvs-${CVSDATE}"
RDEPENDS = "opie-keytabs"
APPNAME = "opie-console"
APPTYPE = binary
PR = "r1"

SRC_URI = "${HANDHELDS_CVS};module=opie/noncore/apps/${APPNAME} \
           ${HANDHELDS_CVS};module=opie/pics \
           ${HANDHELDS_CVS};module=opie/apps"
S = "${WORKDIR}/${APPNAME}"

inherit opie

do_install() {
    install -d ${D}/${palmtopdir}/pics/console/
    install -m 0644 ${WORKDIR}/pics/console/*.png ${D}/${palmtopdir}/pics/console/
}
