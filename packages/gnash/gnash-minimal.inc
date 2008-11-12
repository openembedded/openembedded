DESCRIPTION = "Gnash is a GNU Flash movie player that supports many SWF v7 features"
HOMEPAGE = "http://www.gnu.org/software/gnash"
LICENSE = "GPL-2"

DEPENDS = "virtual/libiconv virtual/libintl libtool agg libxml2 zlib boost jpeg pango curl freetype \
           ${@base_conditional('ENTERPRISE_DISTRO', '1', '', 'ffmpeg libmad', d)}"
RRECOMMENDS_${PN} = "libltdl"

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
                --enable-agg \
                --enable-gui=fb \
                --enable-z \
                --enable-jpeg \
                --disable-klash \
                --disable-glext \
                --disable-Xft \
                --disable-expat \
                ${@base_conditional('ENTERPRISE_DISTRO', '1', '', '--enable-mad', d)} \
                --disable-gstreamer \
                ${@base_conditional('ENTERPRISE_DISTRO', '1', '', '--enable-media=ffmpeg', d)} \
                --enable-media=ffmpeg \
                --disable-plugin \
                --disable-cygnal \
                --disable-testsuite \
                --enable-maintainer-mode \
                --enable-fps-debug \
                --enable-allstatic \
                --enable-static \
                --with-top-level=${STAGING_DIR_HOST}/usr \
                --disable-ltdl-install \
                --without-included-ltdl \
#  --with-ltdl-include=${STAGING_INCDIR} \
#  --with-ltdl-lib=${STAGING_LIBDIR} \
"

# the test for error_t is wrong for uclibc, needs _GNU_SOURCE for correct
# detection because uclibc does not have argz.h which enables error_t 
CFLAGS += " -D_GNU_SOURCE  -I${S}/libltdl  -I${STAGING_INCDIR}/libltdl $(pkgconfig --cflags gstreamer)"

PACKAGES =+ "libgnashnet libgnashamf libgnashbase libgnashserver libgnashmedia"

FILES_${PN} += "${datadir}/gnash/*png ${datadir}/gnash/*ico"
FILES_${PN}-dbg += "${libdir}/gnash/.debug"
FILES_${PN}-dev += "${libdir}/gnash/*a"
FILES_libgnashamf = "${libdir}/gnash/libgnashamf-*.so"
FILES_libgnashbase = "${libdir}/gnash/libgnashbase-*.so"
FILES_libgnashmedia = "${libdir}/gnash/libgnashmedia-*.so"
FILES_libgnashserver = "${libdir}/gnash/libgnashserver-*.so"
FILES_libgnashnet = "${libdir}/gnash/libgnashnet.so.*"
