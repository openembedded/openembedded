include evas.inc
DEPENDS = "freetype libpng jpeg eet"
PR = "r0"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/enlightenment;module=e17/libs/evas;date=${PV} \
           file://pkg.m4"
S = "${WORKDIR}/evas"

EXTRA_OECONF = "--enable-fb         \
		--disable-directfb          \
		--disable-buffer            \
		--disable-software-qtopia   \
		--disable-software-x11      \
		--disable-gl-x11            \
		--enable-image-loader-eet   \
		--disable-image-loader-edb  \
		--enable-image-loader-png   \
		--enable-image-loader-jpeg  \
		--enable-small-dither-mask  \
		--enable-cpu-c              \
		--enable-font-loader-eet    \
		--enable-scale-sample       \
		--enable-scale-smooth       \
		--enable-convert-yuv        \
		--disable-convert-8-rgb-332 \
		--disable-convert-8-rgb-666 \
		--disable-convert-8-rgb-232 \
		--disable-convert-8-rgb-222 \
		--disable-convert-8-rgb-221 \
		--disable-convert-8-rgb-121 \
		--disable-convert-8-rgb-111 \
		--enable-convert-16-rgb-565 \
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

headers = "Evas_Engine_Buffer.h \
           Evas_Engine_FB.h \
           Evas.h"
