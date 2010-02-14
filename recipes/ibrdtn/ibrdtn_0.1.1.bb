DESCRIPTION = "Implementation of the bundle protocol RFC5050"
HOMEPAGE = "http://www.ibr.cs.tu-bs.de/projects/ibr-dtn/"
SECTION = "devel"
DEPENDS = "libpthread-stubs sqlite3 lua5.1"
PR = "r0"

SRC_URI = "http://www.ibr.cs.tu-bs.de/projects/ibr-dtn/releases/ibrdtn-${PV}.tar.gz \
        file://0001-fix-header-include-for-gcc44.patch;patch=1 \
        "

inherit autotools

EXTRA_OECONF = "--prefix=${D} --exec-prefix=${D} --libdir=${STAGING_LIBDIR} --includedir=${STAGING_INCDIR}"

do_configure() {
        oe_runconf
}
