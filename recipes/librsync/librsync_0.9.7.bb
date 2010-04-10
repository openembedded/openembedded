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

SRC_URI[md5sum] = "24cdb6b78f45e0e83766903fd4f6bc84"
SRC_URI[sha256sum] = "6633e4605662763a03bb6388529cbdfd3b11a9ec55b8845351c1bd9a92bc41d6"
