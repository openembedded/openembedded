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

SRC_URI[md5sum] = "ee1fcf2e12b74e8cf65f43cdd2c47b72"
SRC_URI[sha256sum] = "5cff4c3269cf006bef9f66ec0a788139689425b96c6d7c60024f0841632b065b"
