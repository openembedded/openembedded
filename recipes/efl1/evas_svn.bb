require evas.inc
PR = "r6"

EVAS_CPU_TWEAKS = ""
EVAS_CPU_TWEAKS_armv7a = "--enable-cpu-neon"

EXTRA_OECONF = "\
		--x-includes=${STAGING_INCDIR}/X11  \
		--x-libraries=${STAGING_LIBDIR} \
        --enable-evas-magic-debug \
        \
		--enable-fb					\
		--disable-directfb			\
		--disable-sdl				\
		--enable-buffer				\
		--disable-software-ddraw	\
		--disable-software-qtopia	\
		--enable-simple-x11		\
		--enable-software-x11		\
		--enable-software-16-x11	\
		--disable-software-xcb		\
		--enable-xrender-x11		\
		--disable-xrender-xcb		\
		--disable-glitz-x11			\
		--enable-image-loader-eet	\
		--disable-image-loader-edb	\
		--disable-image-loader-gif	\
		--enable-image-loader-png	\
		--enable-image-loader-jpeg	\
		--enable-image-loader-tiff	\
		--enable-image-loader-xpm	\
		--enable-image-loader-svg	\
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
		--enable-convert-16-rgb-rot-90	\
		--disable-convert-16-rgb-rot-180 \
		--enable-convert-16-rgb-rot-270	\
		--enable-convert-24-rgb-888	\
		--enable-convert-24-bgr-888	\
		--enable-convert-32-rgb-8888	\
		--enable-convert-32-rgbx-8888	\
		--enable-convert-32-bgr-8888	\
		--enable-convert-32-bgrx-8888	\
		--enable-convert-32-rgb-rot-0	\
		--enable-convert-32-rgb-rot-90	\
		--disable-convert-32-rgb-rot-180 \
		--enable-convert-32-rgb-rot-270 \
		${EVAS_CPU_TWEAKS}"


# either sgx or 6410 atm
GLES ?= "sgx"

# This is a hack to get openGL|ES 2.x support enabled for people that have the SDK headers in staging.
# We put this in the main recipe, since it will just not build the gl stuff when the headers are missing

# If the above sentence confuse you: everything is built and configured as before if you don't have the SDK

EXTRA_OECONF += "\
        --enable-gl-x11 --enable-gl-flavor-gles --enable-gles-variety-${GLES} \
"

