DESCRIPTION = "Implementation of the bundle protocol RFC5050"
HOMEPAGE = "http://www.ibr.cs.tu-bs.de/projects/ibr-dtn/"
SECTION = "devel"
DEPENDS = "libpthread-stubs sqlite3 lua5.1 libnl cppunit"
PR = "r0"

inherit autotools

EXTRA_OECONF = " --with-lowpan "

SRC_URI = "http://www.ibr.cs.tu-bs.de/projects/ibr-dtn/releases/${PN}-${PV}.tar.gz"
