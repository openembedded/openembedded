require htmldoc.inc
DEPENDS += "htmldoc-native fltk"
PR = "r2"


SRC_URI = "http://ftp.rz.tu-bs.de/pub/mirror/ftp.easysw.com/ftp/pub/htmldoc/snapshots/htmldoc-${PV}.tar.bz2 \
file://paths_1.9.x.patch;patch=1"


S = "${WORKDIR}/htmldoc-${PV}"

inherit autotools pkgconfig

EXTRA_AUTORECONF += "--exclude=autoheader"
EXTRA_OECONF += "--disable-localpng --disable-localjpeg --disable-localzlib \
		--with-gui=yes"

FILES_${PN} += "${datadir}/htmldoc/fonts"
FILES_${PN} += "${datadir}/htmldoc/data"


do_install() {
	oe_runmake 'DESTDIR=${D}' install
}
