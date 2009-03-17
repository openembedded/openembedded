DESCRIPTION = "Opie Alarm"
SECTION = "opie/base"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "apmd"
RDEPENDS = "apmd"

S = "${WORKDIR}/opiealarm"

inherit opie

do_install() {
	install -d ${D}${bindir} ${D}${sysconfdir}/apm/event.d/
	install -m 0755 ${S}/opiealarm ${D}${bindir}/
	install -m 0755 ${WORKDIR}/01opiealarm ${D}${sysconfdir}/apm/event.d/
}
