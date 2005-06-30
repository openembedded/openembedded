DESCRIPTION = "Opie QCOP IPC Client"
SECTION = "opie/base"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"

S = "${WORKDIR}/qcop"

inherit opie

do_install() {
	install -d ${D}${palmtopdir}/bin/
	install -m 0755 ${S}/qcop ${D}${palmtopdir}/bin/qcop
}
