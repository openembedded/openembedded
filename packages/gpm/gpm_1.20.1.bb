SECTION = "console/utils"
LICENSE = "GPL"
DEPENDS = "ncurses"
DESCRIPTION = "GPM (General Purpose Mouse) is a mouse server \
for the console and xterm, with sample clients included \
(emacs, etc)."

SRC_URI = "ftp://arcana.linux.it/pub/gpm/gpm-${PV}.tar.bz2 \
	   file://configure.patch;patch=1 \
	   file://no-docs.patch;patch=1"

inherit autotools

export LIBS = "-lm"
do_configure_prepend () {
	cp aclocal.m4 acinclude.m4
}

do_stage () {
	install -m 0644 src/headers/gpm.h ${STAGING_INCDIR}/
	oe_libinstall -so -a -C src/lib libgpm ${STAGING_LIBDIR}
}

do_install () {
	oe_runmake 'ROOT=${D}' install
}
