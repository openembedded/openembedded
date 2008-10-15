DESCRIPTION = "librsync is a free software library that implements the rsync \
remote-delta algorithm. This algorithm allows efficient remote updates of a \
file, without requiring the old and new versions to both be present at the \
sending end."
HOMEPAGE = "http://librsync.sourceforge.net/"
SECTION = "libs"
LICENSE = "LGPL"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/librsync/librsync-${PV}.tar.gz"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-build-docs --enable-shared "

do_stage() {
    oe_libinstall -a -so -C .libs librsync ${STAGING_LIBDIR}
    install -d ${STAGING_INCDIR}/
    for i in librsync.h librsync-config.h
    do
        install -m 0644 ${S}/$i ${STAGING_INCDIR}/$i
    done
}
