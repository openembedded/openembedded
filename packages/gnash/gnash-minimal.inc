DESCRIPTION = "Gnash is a GNU Flash movie player that supports many SWF v7 features"
HOMEPAGE = "http://www.gnu.org/software/gnash"
LICENSE = "GPL-2"
DEPENDS = "libtool agg libxml2 libmad zlib boost jpeg pango curl freetype"

SRC_URI = "ftp://ftp.gnu.org/pub/gnu/gnash/${PV}/gnash-${PV}.tar.bz2"
S = ${WORKDIR}/gnash-${PV}

inherit autotools pkgconfig

# gnash-minimal is intended for running directly on a framebuffer device
# for memory constrained devices, but does not accept all SWF files.
# As such, it is useful as a GUI frontend for dedicated SWF files.

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
                --enable-fps-debug \
                --enable-allstatic \
                --with-top-level=${STAGING_DIR_HOST}/usr \
                "

# the test for error_t is wrong for uclibc, needs _GNU_SOURCE for correct
# detection because uclibc does not have argz.h which enables error_t 
CFLAGS += " -D_GNU_SOURCE "

PACKAGES =+ " libgnashamf libgnashbase libgnashserver libgnashmedia libltdl"

FILES_libltdl = "${libdir}/gnash/libltdl*.so*"
FILES_libgnashamf = "${libdir}/gnash/libgnashamf-${PV}.so"
FILES_libgnashbase = "${libdir}/gnash/libgnashbase-${PV}.so"
FILES_libgnashmedia = "${libdir}/gnash/libgnashmedia-${PV}.so"
FILES_libgnashserver = "${libdir}/gnash/libgnashserver-${PV}.so"

