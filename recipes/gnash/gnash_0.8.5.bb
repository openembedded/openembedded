require gnash.inc

DEPENDS += "gst-plugins-base"

acpaths = " -Imacros"

DEFAULT_PREFERENCE = "-1"

# Boost lacks defines for lots of archs
TARGET_CC_ARCH_append = " -I${STAGING_INCDIR}/libxml2 -DHAVE_POLL_H ${@[' -D_BIG_ENDIAN', ' -D_LITTLE_ENDIAN'][bb.data.getVar('SITEINFO_ENDIANESS', d, 1) == 'le']}"


do_configure_prepend() {
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
                  --enable-media=gst \
				"

