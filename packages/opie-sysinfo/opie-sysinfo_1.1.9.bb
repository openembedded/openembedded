DESCRIPTION = "System Information dialog for the Opie environment"
SECTION = "opie/settings"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"

APPNAME = "sysinfo"


SRC_URI = "${HANDHELDS_CVS};tag=${TAG};module=opie/noncore/settings/sysinfo \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/pics \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/apps \
           ${HANDHELDS_CVS};tag=${TAG};module=opie/share"
S = "${WORKDIR}/${APPNAME}"

inherit opie

do_install() {
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
        install -d ${D}${palmtopdir}/share/sysinfo/
        install -m 0644 ${WORKDIR}/share/sysinfo/results ${D}${palmtopdir}/share/sysinfo/results
}

