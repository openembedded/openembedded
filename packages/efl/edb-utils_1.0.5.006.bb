DESCRIPTION = "EDB is a database convenience library wrapped around the \
Berkeley DB 2.7.7 by Sleepycat Software."
DEPENDS = "zlib ncurses"
LICENSE = "BSD"
PR = "r4"

inherit efl

EXTRA_OECONF += "--disable-gtk"

PACKAGES = "edb-utils"
FILES_${PN} = "${bindir}/edb_ed ${bindir}/edb_vt_ed ${bindir}/edb_gtk_ed"
RDEPENDS_${PN} += "ncurses"

SRC_URI = "${E_URI}/edb-${PV}.tar.gz"
S = "${WORKDIR}/edb-${PV}"

libraries = ""
headers = ""
