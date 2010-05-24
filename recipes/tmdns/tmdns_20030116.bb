LICENSE = "GPL"
SECTION = "console/network"
DESCRIPTION = "tmdns is a multicast DNS server."

SRC_URI = "cvs://anonymous:@zeroconf.cvs.sourceforge.net/cvsroot/zeroconf;module=tmdns;date=${PV} \
	   file://install-init.d.patch;apply=yes \
	   file://busybox-init.d.patch;apply=yes \
	   file://char-signed-idiocy.patch;apply=yes"
S = "${WORKDIR}/tmdns"

inherit autotools

do_install () {
	oe_runmake 'DESTDIR=${D}' 'INIT_DIR=${sysconfdir}/init.d' install
}
