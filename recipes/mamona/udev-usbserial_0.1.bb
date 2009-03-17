DESCRIPTION = "Udev rules file to spawn getty in ttyUSB"
SECTION = "utils"
LICENSE = "GPL"
RDEPENDS = "udev"
PR = "r1"

PACKAGES = "${PN}"

SRC_URI = "file://80-usbconsole.rules"

inherit autotools

# Skipping...
do_configure () {
}
# Skipping...
do_stage () {
}
# Skipping...
do_compile () {
}

do_install () {
    install -d ${D}${sysconfdir}/udev/rules.d
    install -m 0644 ${WORKDIR}/80-usbconsole.rules ${D}${sysconfdir}/udev/rules.d
}

pkg_postinst_${PN}() {
    udevcontrol reload_rules || true
}
