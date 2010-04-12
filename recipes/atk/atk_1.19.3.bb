require atk.inc

SRC_URI = "ftp://ftp.gnome.org/pub/GNOME/sources/atk/1.19/atk-${PV}.tar.bz2"

CFLAGS_append = "\
	-I${STAGING_INCDIR}/glib-2.0 \
	-I${STAGING_INCDIR}/glib-2.0/glib \
	-I${STAGING_INCDIR}/glib-2.0/gobject \
	"

do_stage () {
	oe_libinstall -so -C atk libatk-1.0 ${STAGING_LIBDIR}
	autotools_stage_includes
}

SRC_URI[md5sum] = "2babc7fa144688274ebede271072b8e2"
SRC_URI[sha256sum] = "f616b4b636957e6387392ecacea4d60e4ad178baa3c9713e5db1733a42326786"
