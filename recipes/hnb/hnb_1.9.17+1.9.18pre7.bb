DESCRIPTION = "hnb is a text-mode hierarchical outliner"
SECTION = "console/pim"
HOMEPAGE = "http://hnb.sf.net"
LICENSE = "GPL"
DEPENDS = "ncurses"

SRC_URI = "http://hnb.sourceforge.net/.files/hnb-1.9.18.pre7.tar.gz"
S = "${WORKDIR}/hnb-1.9.18.pre7"

EXTRA_OEMAKE = '"LIBS=-L${STAGING_LIBDIR} -lncurses libcli/libcli.a"'

do_install() {
	install -d ${D}${bindir}
	install -m 0755 src/hnb ${D}${bindir}
	install -d ${D}${mandir}/man1
	install -m 0644 doc/hnb.1 ${D}${mandir}/man1/
}


SRC_URI[md5sum] = "65196f236b40ecc8bfccf8aec36e91f6"
SRC_URI[sha256sum] = "0102d55afe4d2071b088624f401f8b830659cb63c3364d3c6e089b4e74138bcc"
