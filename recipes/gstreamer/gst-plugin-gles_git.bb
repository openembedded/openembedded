DESCRIPTION = "GStreamer OpenGL/GLES2 plugins"
LICENSE = "LGPL"

SRCREV = "18f5c4875006606b28aa9aa366abbc5dd1e16b60"

PR = "r1"
PR_append = "+gitr${SRCREV}"
PV = "0.10"

DEPENDS = "virtual/libsdl libgles-omap3 gstreamer gst-plugins-base"


SRC_URI = "git://anongit.freedesktop.org/gstreamer/gst-plugins-gl;protocol=git \
           http://gstreamer.freedesktop.org/src/gstreamer/gstreamer-0.10.23.tar.bz2 \
           file://omap3_fix_renderbuffer_storage.patch;patch=1 \
"

S = "${WORKDIR}/git"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-tests --disable-examples"

do_configure_prepend () {
	cp -rf ${WORKDIR}/gstreamer-0.10.23/common/* ${S}/common/
	cp -rf ${WORKDIR}/gstreamer-0.10.23/po/* ${S}/po/
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


FILES_${PN} = "${libdir}/gstreamer-0.10/libgstopengl.so \
               ${libdir}/libgstgl-0.10.so.0"

FILES_${PN}-dev += "\
  ${libdir}/gstreamer-0.10/libgstopengl.* \
"

FILES_${PN}-dbg += "${libdir}/gstreamer-0.10/.debug"

INSANE_SKIP_${PN} = True

