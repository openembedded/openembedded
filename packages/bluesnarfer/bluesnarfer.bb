DESCRIPTION = "Bluetooth cellphone information gatherer"
LICENSE = "GPL"
SECTION = "network/misc"
DEPENDS = "bluez-libs"
PV = "0.1"

SRC_URI = "http://www.alighieri.org/tools/bluesnarfer.tar.gz"
S = "${WORKDIR}/bluesnarfer"

LDFLAGS =+ "-lbluetooth"

do_compile() {
	oe_runmake bluesnarfer
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 ${S}/bluesnarfer ${D}${bindir}
}
