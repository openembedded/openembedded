DESCRIPTION = "A mode switching tool for controlling 'flip flop' (multiple device) USB gear"
SECTION = "base"
PRIORITY = "required"
LICENSE = "GPLv2"
DEPENDS = "virtual/libusb0"

PR = "r4"

SRC_URI = "http://www.draisberghof.de/usb_modeswitch/usb-modeswitch-${PV}.tar.bz2 \
           file://fix-install-in-makefile.patch \
           "
SRC_URI[md5sum] = "a04db36bd0fc6fb303df7567f677b714"
SRC_URI[sha256sum] = "c20abfdf9d46fb83e1b82f961a9f6ec8064bed3304155b6e1af7cf596845d0d0"

FILES_${PN} = "${bindir} ${sysconfdir} ${base_libdir}/udev/usb_modeswitch ${sbindir}"
RPROVIDES_${PN} += "usbmodeswitch"
RREPLACES_${PN} += "usbmodeswitch"
RRECOMMENDS_${PN} = "usb-modeswitch-data"

do_install() {
	oe_runmake install DESTDIR=${D}
}

