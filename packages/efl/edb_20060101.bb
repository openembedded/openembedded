DESCRIPTION = "EDB is a database convenience library wrapped around the \
Berkeley DB 2.7.7 by Sleepycat Software."
DEPENDS = "zlib ncurses"
LICENSE = "BSD"
PR = "r1"

inherit efl

SRC_URI = "cvs://anonymous@thinktux.net/root;module=e17/libs/edb;date=${PV}"
S = "${WORKDIR}/edb"

EXTRA_OECONF += "--disable-gtk"

libdirectory = "src"

FILES_${PN}-dev += "${bindir}/edb_ed ${bindir}/edb_vt_ed ${bindir}/edb_gtk_ed"
RDEPENDS_${PN}-dev += "ncurses"