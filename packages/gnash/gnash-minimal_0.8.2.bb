require gnash.inc

# gnash-minimal is intended for running directly on a framebuffer device
# for memory constrained devices, but does not accept all SWF files.
# It is useful as a GUI frontend for dedicated SWF files.

DEFAULT_PREFERENCE = "-1"

DEPENDS = "agg libxml2 libmad zlib boost jpeg pango curl freetype"

S = ${WORKDIR}/gnash-${PV}

# JPEG support and libz cannot be disabled due to a bug in 0.8.2.
# maintainer-mode is enabled to disable the testsuite.

EXTRA_OECONF="--enable-gui=gtk \
                --enable-renderer=agg \
                --enable-media=none \
                --enable-agg \
                --enable-gui=fb \
                --enable-z \
                --enable-jpeg \
                --disable-klash \
                --disable-glext \
                --disable-Xft \
                --disable-expat \
                --disable-mad \
                --disable-gstreamer \
                --disable-cairo \
                --disable-plugin \
                --disable-cygnal \
		--disable-testsuite \
                --enable-maintainer-mode \
                --with-top-level=${STAGING_DIR_HOST}/usr \
                "
