DESCRIPTION = "Image loading library"
LICENSE = "GPLv2"
DEPENDS = "gtk+-1.2 jpeg tiff libpng libungif"

inherit gnome binconfig

SRC_URI += "file://configure.patch;patch=1"

EXTRA_OECONF = " --enable-modules \
		 --disable-gtktest \
		ac_cv_dynworks=true \
		"

do_stage() {
	install -m 644 Imlib/*.h ${STAGING_INCDIR}
	install -m 644 gdk_imlib/*.h ${STAGING_INCDIR}
	oe_libinstall -a -so -C Imlib libImlib ${STAGING_LIBDIR}
	oe_libinstall -a -so -C gdk_imlib libgdk_imlib ${STAGING_LIBDIR}
}

