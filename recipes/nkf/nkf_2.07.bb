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

SRC_URI[md5sum] = "af11dcd3fe71d67831c020e3bfd5073b"
SRC_URI[sha256sum] = "71d2ba992df209a00bb1dca45e3336729dc16e51b71526bd20f897cc6127a275"
