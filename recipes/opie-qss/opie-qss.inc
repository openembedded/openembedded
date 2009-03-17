DESCRIPTION = "Opie Sound Sever Daemon"
SECTION = "opie/base"
PRIORITY = "optional"
LICENSE = "GPL"

S = "${WORKDIR}/qss"

inherit opie

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/qss ${D}${bindir}/qss
}
