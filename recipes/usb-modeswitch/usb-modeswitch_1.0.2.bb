DESCRIPTION = "A mode switching tool for controlling 'flip flop' (multiple device) USB gear"
SECTION = "base"
PRIORITY = "required"
LICENSE = "GPLv2"
DEPENDS = "virtual/libusb0"

SRC_URI = "http://www.draisberghof.de/usb_modeswitch/usb_modeswitch-${PV}.tar.bz2"

S = "${WORKDIR}/usb_modeswitch-${PV}"

PACKAGES = "${PN}"
FILES_${PN} = "${bindir} ${sysconfdir}"

do_compile() {
	oe_runmake
}

do_install() {
	install -d ${D}${bindir}
	install -d ${D}${sysconfdir}
	install -m 0755 ${S}/usb_modeswitch ${D}${bindir}/usb_modeswitch
	install -m 0644 ${S}/usb_modeswitch.conf ${D}${sysconfdir}/usb_modeswitch.conf
}
