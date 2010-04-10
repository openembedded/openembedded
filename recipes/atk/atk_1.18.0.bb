require atk.inc

SRC_URI = "http://ftp.gnome.org/pub/GNOME/sources/atk/1.18/atk-${PV}.tar.bz2"

do_stage () {
	oe_libinstall -so -C atk libatk-1.0 ${STAGING_LIBDIR}
	autotools_stage_includes
}

SRC_URI[md5sum] = "9fc33ec48fd32933f7f630479dfad667"
SRC_URI[sha256sum] = "be2d537642a43b5a1e85a2d0f813167b8585781ff83203a4f68206c3ecd6a315"
