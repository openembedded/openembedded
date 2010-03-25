DESCRIPTION = "Terminal screen handling and optimization"
SECTION = "libs"
LICENSE = "Artistic|GPL"
DEPENDS = "ncurses"
BBCLASSEXTEND = "native"

PR = "r0"

SRC_URI = "http://search.cpan.org/CPAN/authors/id/G/GI/GIRAFFED/Curses-${PV}.tgz;name=curses-perl-${PV}"
SRC_URI[curses-perl-1.28.md5sum] = "ed9f7ddf2d90f4266da91c3dc9fad9c9"
SRC_URI[curses-perl-1.28.sha256sum] = "613b73c4b6075b1550592812214e4fc0e2205d3afcf234e3fa90f208fb8de892"

S = "${WORKDIR}/Curses-${PV}"

inherit cpan

CFLAGS += "-D_LARGEFILE_SOURCE -D_LARGEFILE64_SOURCE"
BUILD_CFLAGS += "-D_LARGEFILE_SOURCE -D_LARGEFILE64_SOURCE"
export CURSES_CFLAGS="-I${STAGING_INCDIR}"
export CURSES_LDFLAGS="-lncurses"
