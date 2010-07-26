require gnash.inc

DEPENDS += "gst-plugins-base cairo"

acpaths = " -Imacros"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_angstrom = "1"

# Boost lacks defines for lots of archs
TARGET_CC_ARCH_append = " -I${STAGING_INCDIR}/libxml2 -DHAVE_POLL_H ${@[' -D_BIG_ENDIAN', ' -D_LITTLE_ENDIAN'][bb.data.getVar('SITEINFO_ENDIANESS', d, 1) == 'le']}"


do_configure_prepend() {
	# fix an upstream case-typo in the configure script
	sed -i s:Media_handler:media_handler:g ${S}/configure.ac
	sed -i -e 's:GNASH_PKG_FIND(libpng:GNASH_PKG_FIND(png:g' ${S}/configure.ac
	for i in $(find ${S} -name "Makefile.am") ; do	
		sed -i -e s:LIBPNG:PNG:g $i
	done
	export CFLAGS="${CFLAGS} -lpng"
}

do_install_append() {
	oe_runmake DESTDIR=${D} install-plugin
}


EXTRA_OECONF += " --without-included-ltdl \
                  --with-ltdl-include=${STAGING_INCDIR} \
                  --with-ltdl-lib=${STAGING_LIBDIR} \
                  --enable-plugins \
                  --enable-npapi \
                  --with-npapi-plugindir=${libdir}/mozilla/plugins \
                  --enable-mit-shm \
                  --enable-png \
                  --with-png-incl=${STAGING_INCDIR} \
                  --with-png-lib=${STAGING_LIBDIR} \
                  --with-cairo-incl=${STAGING_DIR_HOST}/usr/include/cairo \
                  --with-cairo-lib=${STAGING_DIR_HOST}/usr/lib \
                  --enable-media=gst \
                  --disable-speex \
                  --disable-speexdsp \
                "


SRC_URI[md5sum] = "366f703c2eb1747e4109602b75439ff4"
SRC_URI[sha256sum] = "16f272214eed2ab50bcd9507d6299b82ed7d20e7e8eb253ab160e594eeb210b3"
