require gnash.inc

DEFAULT_PREFERENCE = "-1"

do_configure_prepend() {
	sed -i -e 's:GNASH_PKG_FIND(libpng:GNASH_PKG_FIND(png:g' ${S}/configure.ac
	for i in $(find ${S} -name "Makefile.am") ; do	
		sed -i -e s:LIBPNG:PNG:g $i
	done
	export CFLAGS="${CFLAGS} -lpng"
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
                "


SRC_URI[md5sum] = "b47a7ed4b7c66b8c2ebacc2286ef0d4b"
SRC_URI[sha256sum] = "6ffe4bdbc22de712e59205a27b46aa93a5372c67829c7f02d6b1c1778e9f9224"
