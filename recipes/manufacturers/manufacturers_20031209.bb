SECTION = "base"
DESCRIPTION = "Ethernet manufacturer database"
LICENSE = "PD"
SRCDATE = "${PV}"

PR = "r1"

SRC_URI = "${OPIE_GIT};protocol=git;subpath=etc"
S = "${WORKDIR}/etc"

do_install() {
	install -d ${D}${sysconfdir}
	install -m 0644 manufacturers ${D}${sysconfdir}/
}
