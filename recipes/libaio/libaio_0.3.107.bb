DESCRIPTION="Asynchronous input/output library that uses the kernels native interface"
LICENSE = "LGPL"
PR = "r0"

FILESPATHPKG .= ":libaio-0.3.106"

SRC_URI = "${DEBIAN_MIRROR}/main/liba/libaio/libaio_${PV}.orig.tar.gz \
           file://00_arches.patch \
           file://destdir.patch"

do_install () {
    oe_runmake install DESTDIR=${D}
}

SRC_URI[md5sum] = "db32c19c61ca937bcb1ba48da9180682"
SRC_URI[sha256sum] = "e6ad9246d7cd615d90fb3d231eec94111a36a85e9ffc759ac6bdab1a03995f27"
