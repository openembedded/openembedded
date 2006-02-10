DESCRIPTION = "EDB is a database convenience library wrapped around the \
Berkeley DB 2.7.7 by Sleepycat Software."
DEPENDS = "zlib ncurses"
LICENSE = "BSD"
PR = "r2"

PACKAGES = "edb-utils"
FILES_edb-utils = "${bindir}/edb_ed ${bindir}/edb_vt_ed ${bindir}/edb_gtk_ed"
RDEPENDS_edb-utils += "ncurses"

inherit efl

EXTRA_OECONF += "--disable-gtk"

libdirectory = "src"
