require gst-plugins-package.inc

DESCRIPTION = "GStreamer OpenGL/GLES2 plugins"
LICENSE = "LGPL"

SRCREV = "eebd5c7587530521741155b6cc01c71d5d3c1bf5"
#"15f8e2d17a61bf505c2c6fcd1296f776cd48dfee"

PR = "r0"
PR_append = "+gitr${SRCREV}"
PV = "0.10.1.1"

DEPENDS = "virtual/libsdl libgles-omap3 gstreamer gst-plugins-base"


SRC_URI = "git://anongit.freedesktop.org/gstreamer/gst-plugins-gl;protocol=git \
           http://gstreamer.freedesktop.org/src/gstreamer/gstreamer-0.10.29.tar.bz2 \
"

SRC_URI[md5sum] = "c92d6bce4fc65fa9d5a3ad35cdd1a466"
SRC_URI[sha256sum] = "e44a737c016ccab56d646718ecf24b9393babde2c417ac7dd5bd218e5c609ef9"


S = "${WORKDIR}/git"

inherit autotools pkgconfig

EXTRA_OECONF = "   --disable-rpath --disable-tests --disable-examples"

do_configure_prepend () {
	cp -Rf ${WORKDIR}/gstreamer-0.10.29/common/* ${S}/common/
	cp -Rf ${WORKDIR}/gstreamer-0.10.29/po/* ${S}/po/
	autopoint --force
	sed -i -e '/po /d' ${S}/Makefile.am
}

do_configure () {
	#Hack to force GLES2
	acl_cv_hardcode_libdir_flag_spec= ac_cv_header_GL_gl_h=no autotools_do_configure

	#Hack to disable Werror (treat warning as errors)
	for i in $(find "${S}" -name Makefile) ; do
		sed -i -e 's:-Wl,-rpath-link,${STAGING_LIBDIR}::g' -e s:\Werror\:\Wno-error\:g $i
	done
}
GST_LIBV = 0.10

do_install() {
	install -d ${D}${libdir}/gstreamer-${GST_LIBV}/
	install -m 0755 gst/gl/.libs/libgstopengl.so ${D}${libdir}/gstreamer-${GST_LIBV}
	install -m 0755 gst-libs/gst/gl/.libs/libgstgl-0.10.so.0.0.0 ${D}${libdir}/libgstgl-0.10.so.0
}

# bad rpaths we can't get rid off..
INSANE_SKIP_gst-plugin-opengl = True

