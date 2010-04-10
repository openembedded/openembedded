LICENSE = "GPLv2"
SRC_URI = "http://download.librdf.org/source/redland-1.0.8.tar.gz \
           file://crosscompile.patch;patch=1 \
	   file://sane_pkgconfig.patch;patch=1"
	   
PR = "r3"

DEPENDS = "db mysql"

inherit autotools_stage

EXTRA_OECONF = "--with-bdb-lib=${STAGING_LIBDIR} --with-bdb-include=${STAGING_INCDIR} --with-sqlite=no"

AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_compile_append() {
for i in `find ${S}/ -name "*.pc" -type f` ; do \
            sed -i -e 's:-L${STAGING_LIBDIR}::g' -e 's:${STAGING_LIBDIR}:\$\{libdir\}:g' $i
        done
}


SRC_URI[md5sum] = "ca66e26082cab8bb817185a116db809b"
SRC_URI[sha256sum] = "8a77fcfd20fea2c6e53761d6dcbbee3fdb35e5308de36c1daa0d2014e5a96afe"
