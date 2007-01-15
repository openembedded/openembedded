include evas.inc
PR = "r5"

EXTRA_OECONF = "--enable-fb         \
		--disable-directfb          \
		--enable-buffer             \
		--disable-software-qtopia   \
		--disable-software-x11      \
		--disable-gl-x11            \
		--disable-xrender-x11       \
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
		--enable-convert-8-rgb-332 \
		--enable-convert-8-rgb-666 \
		--enable-convert-8-rgb-232 \
		--enable-convert-8-rgb-222 \
		--enable-convert-8-rgb-221 \
		--enable-convert-8-rgb-121 \
		--enable-convert-8-rgb-111 \
		--enable-convert-16-rgb-565 \
		--enable-convert-16-rgb-555	\
		--enable-convert-16-rgb-444	\
		--enable-convert-16-rgb-ipq	\
		--enable-convert-16-rgb-rot-0	\
		--enable-convert-16-rgb-rot-90	\
		--enable-convert-16-rgb-rot-270	\
		--enable-convert-24-rgb-888	\
		--enable-convert-24-bgr-888	\
		--enable-convert-32-rgb-8888	\
		--enable-convert-32-rgbx-8888	\
		--enable-convert-32-bgr-8888	\
		--enable-convert-32-bgrx-8888	\
		--enable-convert-32-rgb-rot-0	\
		--enable-convert-32-rgb-rot-90	\
		--enable-convert-32-rgb-rot-270"

headers = "../modules/engines/buffer/Evas_Engine_Buffer.h \
           ../modules/engines/fb/Evas_Engine_FB.h \
           Evas.h"
