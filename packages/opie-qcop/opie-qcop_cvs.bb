DESCRIPTION = "Opie QCOP IPC Client"
SECTION = "opie/base"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
PV = "1.0.1+cvs-${CVSDATE}"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/apps/qcop"
S = "${WORKDIR}/qcop"

inherit opie

do_install() {
	install -d ${D}${palmtopdir}/bin/
	install -m 0755 ${S}/qcop ${D}${palmtopdir}/bin/qcop
}
