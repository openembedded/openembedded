DESCRIPTION = "BUG Avahi Profile"
LICENSE = "MIT"
DEPENDS = "avahi"
PR = "r1"

SRC_URI = "file://bugdevice.service"

S = "${WORKDIR}"

do_install() {
	install -d ${D}${sysconfdir}/avahi/services
	install -m 0644 ${WORKDIR}/bugdevice.service ${D}${sysconfdir}/avahi/services/
}
