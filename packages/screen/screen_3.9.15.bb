SECTION = "console/utils"
DEPENDS = "ncurses"
DESCRIPTION = "Screen is a full-screen window manager \
that multiplexes a physical terminal between several \
processes, typically interactive shells."
LICENSE = "GPL"
SRC_URI = "${GNU_MIRROR}/screen/screen-${PV}.tar.gz \
	   file://configure.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--with-pty-mode=0620 --with-pty-group=5 --disable-pam"

do_configure_prepend () {
	for f in comm.h kmapdef.c term.h tty.c; do
		cp ${S}/$f.dist ${S}/$f
	done
}
