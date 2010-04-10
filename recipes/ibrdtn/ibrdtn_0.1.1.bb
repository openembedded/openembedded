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

SRC_URI[md5sum] = "eb19ac9c283e63afd77215973193f136"
SRC_URI[sha256sum] = "28e9d09e9d2f24f688f66c4fb4b60c374840cb4f754396889bf7725a1ad29e3d"
