DESCRIPTION = "Kernel based automounter for linux."
SECTION = "base"
LICENSE = "GPL"
SRC_URI = "ftp://ftp.kernel.org/pub/linux/daemons/autofs/v3/autofs-${PV}.tar.bz2"

inherit autotools

do_configure_prepend () {
	if [ ! -e acinclude.m4 ]; then
		cp aclocal.m4 acinclude.m4
	fi
}

do_install () {
	install -d ${D}${mandir}/man5 ${D}${mandir}/man8 \
		   ${D}${sbindir}
	oe_runmake 'INSTALLROOT=${D}' install
}
