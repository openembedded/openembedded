DESCRIPTION = "Screen is a full-screen window manager \
that multiplexes a physical terminal between several \
processes, typically interactive shells."
LICENSE = "GPL"
SECTION = "console/utils"
DEPENDS = "ncurses"
PR = "r0"

SRC_URI = "ftp://ftp.uni-erlangen.de/pub/utilities/screen/screen-${PV}.tar.gz \
           ftp://ftp.debian.org/debian/pool/main/s/screen/screen_4.0.2-4.1.diff.gz;patch=1 \
           file://configure.patch;patch=1"

inherit autotools

EXTRA_OECONF = "--with-pty-mode=0620 --with-pty-group=5 --disable-pam"

CFLAGS += "-DPOSIX -Dlinux"

#do_configure_prepend() {
#	for f in comm.h kmapdef.c term.h tty.c; do
#		cp ${S}/$f.dist ${S}/$f
#	done
#}
