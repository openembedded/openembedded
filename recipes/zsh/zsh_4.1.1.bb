DESCRIPTION = "The Zsh shell"
SECTION = "base/shell"
PRIORITY = "optional"
DEPENDS = "ncurses libpcre"
PR = "r2"
LICENSE = "zsh"

SRC_URI = "http://www.zsh.org/pub/old/zsh-${PV}.tar.bz2 \
	 file://configure.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--with-curses-terminfo"
PARALLEL_MAKE = ""

do_configure_prepend () {
	if [ ! -e acinclude.m4 ]; then
		cat aczsh.m4 > acinclude.m4
	fi
}

#kill symlink
do_install_append () {
    mv ${D}${bindir}/zsh-${PV} ${D}${bindir}/zsh
}

SRC_URI[md5sum] = "48958b1a3fc86261a26eea40a4f7d4af"
SRC_URI[sha256sum] = "f539e6db53233fa75d5fa389b4807d54add312fc96de71b5eb7cf4f071719027"
