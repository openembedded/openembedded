DESCRIPTION = "Evas is a clean display canvas API for several target display \
systems that can draw anti-aliased text, smooth super and sub-sampled scaled \
images, alpha-blend objects much and more."
HOMEPAGE = "http://www.enlightenment.org"
MAINTAINER = "Carsten Haitzler (Rasterman) <raster@rasterman.com>"
SECTION = "e/libs"
PRIORITY = "optional"
DEPENDS = "libpng jpeg eet freetype"
PR = "1"

do_prepsources () {
  make clean distclean || true
}
addtask prepsources after do_fetch before do_unpack
  
SRC_URI = "cvs://anonymous@cvs.sourceforge.net:/cvsroot/enlightenment;module=evas"
S = "${WORKDIR}/evas"
  
inherit autotools pkgconfig binconfig

EXTRA_OECONF = "--enable-fb			\
		--disable-directfb		\
		--enable-buffer			\
		--disable-software-qtopia	\
		--enable-software-x11		\
		--disable-gl-x11		\
		--disable-cairo-x11		\
		--enable-image-loader-eet	\
		--disable-image-loader-edb	\
		--enable-image-loader-png	\
		--enable-image-loader-jpeg	\
		--enable-small-dither-mask	\
		--enable-cpu-c			\
		--enable-font-loader-eet	\
		--enable-scale-sample		\
		--enable-scale-smooth		\
		--enable-convert-yuv		\
		--disable-small-dither-mask	\
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

export CFLAGS="-O3 -mcpu=xscale -mtune=xscale"
export FREETYPE_CONFIG = "${STAGING_BINDIR}/freetype-config"
export EET_CONFIG = "${STAGING_BINDIR}/eet-config"

do_configure () {
  autotools_do_configure
}

headers = "Evas_Engine_Buffer.h \
           Evas_Engine_Software_X11.h \
           Evas_Engine_FB.h \
           Evas.h"

do_stage () {
  for i in ${headers}; do
    install -m 0644 ${S}/src/lib/$i ${STAGING_INCDIR}/
  done
  oe_libinstall -C src/lib libevas ${STAGING_LIBDIR}/
}

PACKAGES += "evas-examples"

FILES_${PN} = "${libdir}/libevas*.so*"
FILES_${PN}-dev += "${bindir}/evas-config ${libdir}/pkgconfig"
FILES_${PN}-examples = "${bindir}/evas_fb_test"
FILES_${PN}-examples += "${bindir}/evas_software_x11_test"
FILES_${PN}-examples += "${bindir}/evas_buffer_x11_test"
FILES_${PN}-examples += "${datadir}"
