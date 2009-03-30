
DEPENDS = "libogg libvorbis"

PR = "r3"

SRC_URI = "http://downloads.xiph.org/releases/theora/libtheora-${PV}.tar.bz2 \
	   file://libtheora-1.0-no-docs.patch;patch=1"

inherit autotools lib_package

EXTRA_OECONF = "--disable-examples"

LEAD_SONAME = "libtheora.so.0"

do_configure_append() {
        find ${S} -name Makefile | xargs sed -i -e s:'-I/usr/include':-I${STAGING_INCDIR}:g
}

AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_stage() {
         autotools_stage_all
}
