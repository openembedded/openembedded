SECTION = "console/network"
DEPENDS = "openssl readline"
DESCRIPTION = "Socat is a network relay for bidirectional data \
transfer between two independent data channels."
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://www.dest-unreach.org/socat/download/${P}.tar.bz2 \
           file://socat-1.7.1.2-cross.patch;patch=1 "

inherit autotools

do_configure() {
	# Override this function so the included config.h.in is used instead
	# of recreating it with autoheader.
	(cd ${S} && gnu-configize) || die "failure in running gnu-configize"
	oe_runconf
}

do_install_prepend () {
	mkdir -p ${D}${bindir}
	install -d ${D}${bindir} ${D}${mandir}/man1
}
