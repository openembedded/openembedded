DESCRIPTION = "The Zsh shell"
SECTION = "base/shell"
PRIORITY = "optional"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
DEPENDS = "ncurses pcre"
PR = "r1"
LICENSE = "zsh"

SRC_URI = "http://www.zsh.org/pub/zsh-${PV}.tar.bz2 \
	 file://configure.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--with-curses-terminfo"
do_configure_prepend () {
	if [ ! -e acinclude.m4 ]; then
		cat aczsh.m4 > acinclude.m4
	fi
}
