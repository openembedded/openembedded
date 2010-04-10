require gnash.inc

DEPENDS += "gst-plugins-base agg libmad"

acpaths = " -Imacros"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_angstrom = "1"

SRC_URI += "file://gnash-glib-dependency.patch;patch=1"

S = "${WORKDIR}/gnash-${PV}"

# Boost lacks defines for lots of archs
TARGET_CC_ARCH_append = " -I${STAGING_INCDIR}/libxml2 -DHAVE_POLL_H ${@[' -D_BIG_ENDIAN', ' -D_LITTLE_ENDIAN'][bb.data.getVar('SITEINFO_ENDIANESS', d, 1) == 'le']}"


do_configure_prepend() {
	# fix an upstream case-typo in the configure script
	sed -i s:Media_handler:media_handler:g ${S}/configure.ac
	# find png not libpng
	sed -i -e 's:GNASH_PKG_FIND(libpng:GNASH_PKG_FIND(png:g' ${S}/configure.ac
	for i in $(find ${S} -name "Makefile.am") ; do	
		sed -i -e s:LIBPNG:PNG:g $i
	done
	export CFLAGS="${CFLAGS} -lpng"
}

do_install_append() {
	oe_runmake DESTDIR=${D} install-plugin
}

EXTRA_OECONF = "--enable-gui=fb \
                --enable-renderer=agg \
                --disable-klash \
                --enable-z \
                --enable-jpeg \
                --disable-glext \
                --enable-Xft \
                --enable-expat \
                --enable-mad \
                --enable-cairo \
                --enable-plugin \
                --enable-plugins \
                --enable-npapi \
                --with-npapi-plugindir=${libdir}/mozilla/plugins \
                --enable-mit-shm \
                --disable-cygnal \
                --with-top-level=${STAGING_DIR_HOST}/usr \
                --without-included-ltdl \
                --with-ltdl-include=${STAGING_INCDIR} \
                --with-ltdl-lib=${STAGING_LIBDIR} \
                --enable-png \
                --with-png-incl=${STAGING_INCDIR} \
                --with-png-lib=${STAGING_LIBDIR} \
                --with-cairo-incl=${STAGING_DIR_HOST}/usr/include/cairo \
                --with-cairo-lib=${STAGING_DIR_HOST}/usr/lib \
                --enable-media=gst \
                --with-gstreamer-incl=${STAGING_DIR_HOST}/usr/include/gstreamer-0.10 \
                --with-gstreamer-lib=${STAGING_DIR_HOST}/usr/lib \
                --with-glib-incl=${STAGING_DIR_HOST}/usr/include/glib-2.0 \
                --with-glib-lib=${STAGING_DIR_HOST}/usr/lib \
                --disable-speex \
                --disable-speexdsp \
                "


SRC_URI[md5sum] = "366f703c2eb1747e4109602b75439ff4"
SRC_URI[sha256sum] = "16f272214eed2ab50bcd9507d6299b82ed7d20e7e8eb253ab160e594eeb210b3"
