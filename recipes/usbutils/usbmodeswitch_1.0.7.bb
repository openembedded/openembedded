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


SRC_URI[md5sum] = "a9d05c785ade1b06097d53f4423bd5c6"
SRC_URI[sha256sum] = "ce4985544ea9a252d43cd031823938d51a28e7a9f449ff4403295d1654a3b9d9"
