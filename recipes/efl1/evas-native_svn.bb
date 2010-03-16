require evas.inc
inherit native
DEPENDS = "freetype-native libxext-native libpng-native jpeg-native eet-native eina-native libfribidi-native"
PR = "r3"

EXTRA_OECONF = "\
		--x-includes=${STAGING_INCDIR}/X11  \
		--x-libraries=${STAGING_LIBDIR} \
		--enable-evas-magic-debug \
		\
		--enable-fb				\
		--disable-directfb			\
		--disable-sdl				\
		--enable-buffer				\
		--disable-software-ddraw	\
		--disable-software-qtopia	\
		--disable-software-x11		\
		--disable-software-16-x11	\
		--disable-software-xcb		\
		--disable-gl-x11			\
		--disable-xrender-x11		\
		--disable-xrender-xcb		\
		--disable-glitz-x11			\
		--enable-image-loader-eet	\
		--disable-image-loader-edb	\
		--disable-image-loader-gif	\
		--enable-image-loader-png	\
		--enable-image-loader-jpeg	\
		--enable-image-loader-tiff	\
		--enable-image-loader-xpm	\
		--disable-image-loader-svg	\
		--enable-cpu-c				\
		--enable-fontconfig			\
		--enable-font-loader-eet	\
		--enable-scale-sample		\
		--enable-scale-smooth		\
		--enable-convert-yuv		\
		--enable-small-dither-mask	\
		--disable-no-dither-mask	\
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


