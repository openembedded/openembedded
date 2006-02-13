DESCRIPTION = "EDB is a database convenience library wrapped around the \
Berkeley DB 2.7.7 by Sleepycat Software."
DEPENDS = "zlib ncurses"
LICENSE = "BSD"
PR = "r4"

inherit efl

EXTRA_OECONF += "--disable-gtk"

libdirectory = "src"

FILES_${PN}-examples = ""