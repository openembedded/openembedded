SECTION = "base"
DESCRIPTION = "Ethernet manufacturer database"
LICENSE = "PD"
SRCDATE = "${PV}"
SRCREV = "ff794de4991efa6403b2368edba6eb4e63d8d449"

PR = "r2"

SRC_URI = "${OPIE_GIT};protocol=git;subpath=etc"
S = "${WORKDIR}/etc"

do_install() {
	install -d ${D}${sysconfdir}
	install -m 0644 manufacturers ${D}${sysconfdir}/
}
