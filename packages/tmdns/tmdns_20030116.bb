LICENSE = "GPL"
SECTION = "console/network"
DESCRIPTION = "tmdns is a multicast DNS server."

SRC_URI = "cvs://anonymous:@cvs.sourceforge.net/cvsroot/zeroconf;module=tmdns;date=${PV} \
	   file://install-init.d.patch;patch=1 \
	   file://busybox-init.d.patch;patch=1 \
	   file://char-signed-idiocy.patch;patch=1"
S = "${WORKDIR}/tmdns"

inherit autotools

do_install () {
	oe_runmake 'DESTDIR=${D}' 'INIT_DIR=${sysconfdir}/init.d' install
}
