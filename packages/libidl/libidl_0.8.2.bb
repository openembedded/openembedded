LICENSE = LGPL
SECTION = "libs"
SRC_URI = "ftp://ftp.gnome.org/pub/GNOME/sources/libIDL/0.8/libIDL-0.8.2.tar.bz2"
S = "${WORKDIR}/libIDL-${PV}"

inherit autotools  pkgconfig

do_stage () {
	oe_runmake install DESTDIR="" bindir=${STAGING_BINDIR} includedir=${STAGING_INCDIR} libdir=${STAGING_LIBDIR} prefix=${STAGING_DIR}
}
