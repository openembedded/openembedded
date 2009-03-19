require atk.inc

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/atk/1.18/atk-${PV}.tar.bz2"

do_stage () {
	oe_libinstall -so -C atk libatk-1.0 ${STAGING_LIBDIR}
	autotools_stage_includes
}
