DESCRIPTION = "CORBA ORB"
LICENSE = "LGPL GPL"
SECTION = "x11/gnome/libs"
SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/ORBit2/2.13/ORBit2-${PV}.tar.bz2 \
           file://configure-lossage.patch;patch=1;pnum=1 \
	   file://gtk-doc.m4 \
	   file://gtk-doc.make"
DEPENDS = "libidl-native popt-native gtk-doc"

S = "${WORKDIR}/ORBit2-${PV}"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/orbit2-${PV}"

PARALLEL_MAKE = ""
inherit autotools native pkgconfig

EXTRA_OECONF = "--disable-gtk-doc"

do_configure_prepend() {
	mkdir -p m4
	install ${WORKDIR}/gtk-doc.m4 ./m4/
	install ${WORKDIR}/gtk-doc.make ./
}

SRC_URI[md5sum] = "8d1e654f9b7e1399dc98da3bb4b96762"
SRC_URI[sha256sum] = "fc87440d252c77f5c1afc17bb3015586cca264bc5fa8794bc54b869b8106265d"
