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

