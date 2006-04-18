SECTION = "console/utils"
LICENSE = "GPL"
DEPENDS = "ncurses"
DESCRIPTION = "GPM (General Purpose Mouse) is a mouse server \
for the console and xterm, with sample clients included \
(emacs, etc)."

PR="r1"
PARALLEL_MAKE=""

SRC_URI = "ftp://arcana.linux.it/pub/gpm/gpm-${PV}.tar.bz2 \
	   file://configure.patch;patch=1 \
	   file://no-docs.patch;patch=1 \
	   file://init"

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
	install -d ${D}/${sysconfdir}/init.d
	install -m 0755 ${WORKDIR}/init ${D}/${sysconfdir}/init.d/gpm
}

pkg_postinst () {
	if test -n "${D}"; then
		D="-r $D"
	fi
	update-rc.d $D gpm defaults
}

pkg_prerm () {
	if test -n "${D}"; then
		D="-r $D"
	fi
	update-rc.d $D gpm remove
}
