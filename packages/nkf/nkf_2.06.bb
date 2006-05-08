DESCRIPTION = "Network Kanji Code Conversion Filter"
LICENSE = "GPL"

SRC_URI = "http://ftp.debian.org/debian/pool/main/n/nkf/nkf_${PV}.orig.tar.gz"
S = "${WORKDIR}/nkf206"

EXTRA_OEMAKE = "-e"

do_install() {
	install -d ${D}${bindir}
	install -m 0755 nkf ${D}${bindir}
}
