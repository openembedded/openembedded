DESCRIPTION = "EDB is a database convenience library wrapped around the \
Berkeley DB 2.7.7 by Sleepycat Software."
DEPENDS = "zlib ncurses"
LICENSE = "BSD"
PR = "r3"

## package.bbclass kills packages when there are duplicates, this means
##  that efl.bbclass can't have PACKAGES += and so the FILES for previous
##  packages take precedence over -utils
#PACKAGES = "edb-utils"
#FILES_edb-utils = "${bindir}/edb_ed ${bindir}/edb_vt_ed ${bindir}/edb_gtk_ed"
#RDEPENDS_edb-utils += "ncurses"

inherit efl

EXTRA_OECONF += "--disable-gtk"

libdirectory = "src"
