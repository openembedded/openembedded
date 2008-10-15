DESCRIPTION="Asynchronous input/output library that uses the kernels native interface"
LICENSE = "LGPL"
PR = "r2"

SRC_URI = "${DEBIAN_MIRROR}/main/liba/libaio/libaio_${PV}.orig.tar.gz \
           file://00_arches.patch;patch=1 \
           file://destdir.patch;patch=1"

do_stage() {
    install -d ${STAGING_INCDIR} ${STAGING_LIBDIR}
    install -m 0644 src/libaio.h ${STAGING_INCDIR}
    oe_libinstall -so -C src libaio ${STAGING_LIBDIR}
}

do_install () {
    oe_runmake install DESTDIR=${D}
}
