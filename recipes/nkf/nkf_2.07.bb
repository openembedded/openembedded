DESCRIPTION = "Network Kanji Code Conversion Filter"
LICENSE = "GPL"

SRC_URI = "http://ftp.debian.org/debian/pool/main/n/nkf/nkf_${PV}.orig.tar.gz"
S = "${WORKDIR}/nkf207"

EXTRA_OEMAKE = "-e"

do_install() {
	install -d ${D}${bindir} ${D}${mandir}/man1
	install -m 0755 nkf ${D}${bindir}
	install -m 0644 nkf.1 ${D}${mandir}/man1
}
