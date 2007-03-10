DESCRIPTION = "ZyDAS ZD1211 Firmware"
HOMEPAGE = "http://zd1211.ath.cx/"
SECTION = "net"
PRIORITY = "optional"
LICENSE = "GPL"

SRC_URI = "${SOURCEFORGE_MIRROR}/zd1211/zd1211-firmware1.3.tar.bz2"

S = "${WORKDIR}/${PN}"

do_install() {
	install -d -m 0755 ${D}/lib/firmware/zd1211
	install -m 0644 ${S}/zd1211* ${D}/lib/firmware/zd1211/
}

FILES_${PN} = "/lib/firmware"
