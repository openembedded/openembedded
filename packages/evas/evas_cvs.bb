DESCRIPTION = "Evas is a hardware-accelerated canvas API that can draw \
anti-aliased text, smooth super and sub-images, alpha-blend, as well as drop \
down to using normal X11 primitives such as pixmaps, lines and rectangles if \
your CPU or graphics hardware are too slow."
LICENSE = "MIT"
HOMEPAGE = "http://www.enlightenment.org"
SECTION = "e/libs"
PRIORITY = "optional"
DEPENDS = "libpng jpeg edb eet freetype"
PV = "${CVSDATE}"
PR = "r4"

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/enlightenment;module=e17/libs/evas \
           file://pkg.m4"
S = "${WORKDIR}/evas"

inherit autotools pkgconfig binconfig

EXTRA_OECONF = "--enable-fb			\
		--disable-directfb		\
		--disable-buffer		\
		--disable-software-qtopia	\
		--disable-software-x11		\
		--disable-gl-x11		\
		--enable-image-loader-eet	\
		--enable-image-loader-edb	\
		--enable-image-loader-png	\
		--enable-image-loader-jpeg	\
		--enable-small-dither-mask	\
		--enable-cpu-c			\
		--enable-font-loader-eet	\
		--enable-scale-sample		\
		--enable-scale-smooth		\
		--enable-convert-yuv		\
		--disable-convert-8-rgb-332	\
		--disable-convert-8-rgb-666	\
		--disable-convert-8-rgb-232	\
		--disable-convert-8-rgb-222	\
		--disable-convert-8-rgb-221	\
		--disable-convert-8-rgb-121	\
		--disable-convert-8-rgb-111	\
		--enable-convert-16-rgb-565	\
		--disable-convert-16-rgb-555	\
		--disable-convert-16-rgb-444	\
		--disable-convert-16-rgb-ipq	\
		--enable-convert-16-rgb-rot-0	\
		--disable-convert-16-rgb-rot-90	\
		--enable-convert-16-rgb-rot-270	\
		--disable-convert-24-rgb-888	\
		--disable-convert-24-bgr-888	\
		--disable-convert-32-rgb-8888	\
		--disable-convert-32-rgbx-8888	\
		--disable-convert-32-bgr-8888	\
		--disable-convert-32-bgrx-8888	\
		--disable-convert-32-rgb-rot-0	\
		--disable-convert-32-rgb-rot-90	\
		--disable-convert-32-rgb-rot-270"

do_configure () {
	install -m 0644 ${WORKDIR}/pkg.m4 acinclude.m4
	autotools_do_configure
}

headers = "Evas_Engine_Buffer.h \
           Evas_Engine_FB.h \
           Evas.h"

# Don't install these headers or subsequent libraries will include support for it:
# Evas_Engine_DirectFB.h \
# Evas_Engine_GL_X11.h \
# Evas_Engine_Software_Win32_GDI.h \
# Evas_Engine_Software_X11.h
# Evas_Engine_Software_Qtopia.h \

do_stage () {
	for i in ${headers}; do
		install -m 0644 ${S}/src/lib/$i ${STAGING_INCDIR}/
	done
	oe_libinstall -C src/lib libevas ${STAGING_LIBDIR}/
}

PACKAGES += "evas-examples"

FILES_${PN} = "${libdir}/libevas*.so*"
FILES_${PN}-dev += "${bindir}/evas-config ${libdir}/pkgconfig"
FILES_${PN}-examples = "${bindir}/evas_fb_test ${datadir}"
