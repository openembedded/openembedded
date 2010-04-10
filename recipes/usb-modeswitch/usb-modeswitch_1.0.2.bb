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

SRC_URI[md5sum] = "4f896ed631f9be0338df9c5a2145ef82"
SRC_URI[sha256sum] = "f1b9388f4507185a4ac30bae3383d9e9bbb95075a14dd188c904cacdd8cf4e66"
