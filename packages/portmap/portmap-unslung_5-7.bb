DESCRIPTION = "RPC program number mapper."
SECTION = "console/network"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://www.uk.debian.org/debian/pool/main/p/portmap/portmap_5.orig.tar.gz \
	http://www.uk.debian.org/debian/pool/main/p/portmap/portmap_${PV}.diff.gz;patch=1 \
	file://no-libwrap.patch;patch=1;pnum=0 \
	file://portmap.init \
	file://make.patch;patch=1"
S = "${WORKDIR}/portmap_5beta"

sbindir = "/sbin"

do_compile() {
	oe_runmake
}

do_install() {
	oe_runmake 'docdir=${datadir}/doc/portmap' \
		   'DESTDIR=${D}' install
}
