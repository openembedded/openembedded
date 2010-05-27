DESCRIPTION = "Implementation of the bundle protocol RFC5050"
HOMEPAGE = "http://www.ibr.cs.tu-bs.de/projects/ibr-dtn/"
SECTION = "devel"
DEPENDS = "libpthread-stubs sqlite3 lua5.1"
PR = "r0"

SRC_URI = "http://www.ibr.cs.tu-bs.de/projects/ibr-dtn/releases/ibrdtn-${PV}.tar.gz \
        "

inherit autotools

EXTRA_OECONF = "--prefix=${D} --exec-prefix=${D} --libdir=${STAGING_LIBDIR} --includedir=${STAGING_INCDIR}"

do_configure() {
        oe_runconf
}

SRC_URI[md5sum] = "7e7063276492dc0a681810ccf7c26a3b"
SRC_URI[sha256sum] = "b6a8c216fe28181484f5758297da3f9f54295199e65ee22acd100c75e1bdadd8"
