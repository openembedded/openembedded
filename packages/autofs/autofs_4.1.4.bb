DESCRIPTION = "Kernel based automounter for linux."
SECTION = "base"
LICENSE = "GPL"

SRC_URI = "ftp://ftp.kernel.org/pub/linux/daemons/autofs/v4/autofs-${PV}.tar.bz2 \
           ftp://ftp.kernel.org/pub/linux/daemons/autofs/v4/autofs-4.1.4-misc-fixes.patch;patch=1 \
           ftp://ftp.kernel.org/pub/linux/daemons/autofs/v4/autofs-4.1.4-multi-parse-fix.patch;patch=1 \
           ftp://ftp.kernel.org/pub/linux/daemons/autofs/v4/autofs-4.1.4-non-replicated-ping.patch;patch=1 \
           file://cross.patch;patch=1 \
           file://Makefile.rules-cross.patch;patch=1"
	   
inherit autotools

EXTRA_OEMAKE="TARGET_PREFIX=${TARGET_PREFIX}"
PARALLEL_MAKE = ""

do_configure_prepend () {
	if [ ! -e acinclude.m4 ]; then
		cp aclocal.m4 acinclude.m4
	fi
}

do_install () {
	oe_runmake 'INSTALLROOT=${D}' install
}
