LICENSE = "GPLv2"
SRC_URI = "http://download.librdf.org/source/redland-1.0.8.tar.gz \
           file://crosscompile.patch;patch=1 \
	   file://sane_pkgconfig.patch;patch=1"
	   
PR = "r3"

inherit autotools_stage

EXTRA_OECONF = "--with-bdb-lib=${STAGING_LIBDIR} --with-bdb-include=${STAGING_INCDIR} --with-sqlite=no"

AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_compile_append() {
for i in `find ${S}/ -name "*.pc" -type f` ; do \
            sed -i -e 's:-L${STAGING_LIBDIR}::g' -e 's:${STAGING_LIBDIR}:\$\{libdir\}:g' $i
        done
}

