DESCRIPTION = "Opie QCOP IPC Client"
SECTION = "opie/base"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
# cvsdate for opie-qcop 1.0 is 20050101
CVSDATE = "20050101"

SRC_URI = "${HANDHELDS_CVS};module=opie/core/apps/qcop"
S = "${WORKDIR}/qcop"

inherit opie

do_install() {
	install -d ${D}${palmtopdir}/bin/
	install -m 0755 ${S}/qcop ${D}${palmtopdir}/bin/qcop
}
