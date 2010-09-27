DESCRIPTION = "A mode switching tool for controlling 'flip flop' (multiple device) USB gear"
SECTION = "base"
PRIORITY = "required"
LICENSE = "GPLv2"
DEPENDS = "virtual/libusb0"

PR = "r1"

SRC_URI = "http://www.draisberghof.de/usb_modeswitch/usb-modeswitch-${PV}.tar.bz2"
SRC_URI[md5sum] = "a04db36bd0fc6fb303df7567f677b714"
SRC_URI[sha256sum] = "c20abfdf9d46fb83e1b82f961a9f6ec8064bed3304155b6e1af7cf596845d0d0"

FILES_${PN} = "${bindir} ${sysconfdir}"
RRECOMMENDS_${PN} = "usb-modeswitch-data"

do_compile() {
	oe_runmake
}

do_install() {
	install -d ${D}${bindir}
	install -d ${D}${sysconfdir}
	install -m 0755 ${S}/usb_modeswitch ${D}${bindir}/usb_modeswitch
	install -m 0644 ${S}/usb_modeswitch.conf ${D}${sysconfdir}/usb_modeswitch.conf
}
