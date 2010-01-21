DESCRIPTION = "tool to switch multidevice usb modes"
LICENSE = "GPL"

DEPENDS = "virtual/libusb"

SRC_URI = "http://www.draisberghof.de/usb_modeswitch/usb_modeswitch-${PV}.tar.bz2"

S = "${WORKDIR}/usb_modeswitch-${PV}"

do_compile() {
	oe_runmake clean
	oe_runmake -e
}

do_install() {
	install -d ${D}$bindir}
	install -m 0755 ${S}/usb_modeswitch ${D}${bindir}
}

