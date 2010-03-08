require gst-plugins-package.inc

DESCRIPTION = "GStreamer OpenGL/GLES2 plugins"
LICENSE = "LGPL"

SRCREV = "3d5ba149ee8c290bf9995cd2f6826b0ff2920adf"

PR = "r3"
PR_append = "+gitr${SRCREV}"
PV = "0.10"

DEPENDS = "virtual/libsdl libgles-omap3 gstreamer gst-plugins-base"


SRC_URI = "git://anongit.freedesktop.org/gstreamer/gst-plugins-gl;protocol=git \
           http://gstreamer.freedesktop.org/src/gstreamer/gstreamer-0.10.23.tar.bz2 \
"

S = "${WORKDIR}/git"

inherit autotools pkgconfig

EXTRA_OECONF = "   --disable-rpath --disable-tests --disable-examples"

do_configure_prepend () {
	cp -rf ${WORKDIR}/gstreamer-0.10.23/common/* ${S}/common/
	cp -rf ${WORKDIR}/gstreamer-0.10.23/po/* ${S}/po/
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

