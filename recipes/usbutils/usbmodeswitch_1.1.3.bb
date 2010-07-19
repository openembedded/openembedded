DESCRIPTION = "tool to switch multidevice usb modes"
LICENSE = "GPL"

DEPENDS = "virtual/libusb0"

SRC_URI = "http://www.draisberghof.de/usb_modeswitch/usb-modeswitch-${PV}.tar.bz2"
SRC_URI[md5sum] = "571e6b81873231246693d18a9912f55d"
SRC_URI[sha256sum] = "7d5f0a45ac03eb578678b1f0c99df924b55de40d684aa02f890958c3fe3fcafb"

S = "${WORKDIR}/usb-modeswitch-${PV}"

CFLAGS += "-lusb"
do_compile() {
	oe_runmake -e
}

do_install() {
	oe_runmake -e install DESTDIR=${D}
}

FILES_${PN} += "${base_libdir}/udev/usb_modeswitch"
