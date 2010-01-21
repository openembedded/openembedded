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
