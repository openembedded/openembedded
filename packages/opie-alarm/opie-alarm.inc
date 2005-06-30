DESCRIPTION = "Opie Alarm"
SECTION = "opie/base"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
DEPENDS = "apmd"
RDEPENDS = "apmd"

S = "${WORKDIR}/opiealarm"

inherit opie

do_install() {
	install -d ${D}${palmtopdir}/bin/ ${D}${sysconfdir}/apm/event.d/
	install -m 0755 ${S}/opiealarm ${D}${palmtopdir}/bin/
	install -m 0755 ${WORKDIR}/01opiealarm ${D}${sysconfdir}/apm/event.d/
}

FILES_${PN} = "${palmtopdir}/bin/opiealarm ${sysconfdir}/apm/event.d/01opiealarm"
