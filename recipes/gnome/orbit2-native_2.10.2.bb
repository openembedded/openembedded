DESCRIPTION = "CORBA ORB"
LICENSE = "LGPL GPL"
SECTION = "x11/gnome/libs"
SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/ORBit2/2.10/ORBit2-${PV}.tar.bz2 \
           file://configure-lossage.patch;patch=1;pnum=1 \
	   file://gtk-doc.m4 \
	   file://gtk-doc.make"
DEPENDS = "libidl-native popt-native gtk-doc"

S = "${WORKDIR}/ORBit2-${PV}"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/orbit2-${PV}"

inherit autotools native pkgconfig

EXTRA_OECONF = "--disable-gtk-doc"

do_configure_prepend() {
	mkdir -p m4
	install ${WORKDIR}/gtk-doc.m4 ./m4/
	install ${WORKDIR}/gtk-doc.make ./
}

SRC_URI[md5sum] = "c862e3261b52a84321e89f57e5600da6"
SRC_URI[sha256sum] = "d43ff15c23f5391850f85a7d40e4bd26f82fe2c86669664fe56eff91f14c1594"
