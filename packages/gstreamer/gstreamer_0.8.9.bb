LICENSE = "LGPL"
PR = "r4"

DESCRIPTION = "GStreamer is a multimedia framework for encoding and decoding video and sound. \
It supports a wide range of formats including mp3, ogg, avi, mpeg and quicktime."
DEPENDS = "glib-2.0 gettext-native popt"
SECTION = "base"
PRIORITY = "optional"

FILES_${PN} += " ${libdir}/gstreamer-0.8/*.so"
FILES_${PN}-dev += " ${libdir}/gstreamer-0.8/*.la ${libdir}/gstreamer-0.8/*.a"

SRC_URI = "http://gstreamer.freedesktop.org/src/gstreamer/gstreamer-${PV}.tar.bz2 \
	file://libm.patch;patch=1 \
	file://no-libxml2.patch;patch=1 \
	file://filesrc-uri.patch;patch=1 \
	file://gstreamer.xsession"

EXTRA_OECONF = "--disable-docs-build --disable-dependency-tracking --disable-loadsave"

inherit autotools pkgconfig

do_stage() {
	oe_runmake install prefix=${STAGING_DIR} \
	       bindir=${STAGING_BINDIR} \
	       includedir=${STAGING_INCDIR} \
	       libdir=${STAGING_LIBDIR} \
	       datadir=${STAGING_DATADIR} \
	       mandir=${STAGING_DIR}/share/man
}

do_install_append() {
	install -d ${D}${sysconfdir}/X11/Xsession.d
	install ${WORKDIR}/gstreamer.xsession ${D}${sysconfdir}/X11/Xsession.d/90gst-register
}

