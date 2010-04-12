DESCRIPTION = "The Zsh shell"
SECTION = "base/shell"
PRIORITY = "optional"
DEPENDS = "ncurses libpcre"
PR = "r1"
LICENSE = "zsh"

SRC_URI = "http://www.zsh.org/pub/zsh-${PV}.tar.bz2 \
"

inherit autotools

do_configure() { 
   oe_runconf
}

EXTRA_OECONF = "--with-term-lib="ncurses" --with-tcsetpgrp"
PARALLEL_MAKE = ""

#Kill symlink
do_install_append () {
    mv ${D}${bindir}/zsh-${PV} ${D}${bindir}/zsh
}

SRC_URI[md5sum] = "74c5b275544400082a1cde806c98682a"
SRC_URI[sha256sum] = "63fdc0273eadbb42d164f38b0b79922c0b3df0e97084e746a318276d935a4f7c"
