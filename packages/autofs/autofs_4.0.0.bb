DESCRIPTION = "Kernel based automounter for linux."
SECTION = "base"
LICENSE = "GPL"

SRC_URI = "ftp://ftp.kernel.org/pub/linux/daemons/autofs/v4/old/autofs-${PV}-1.tar.bz2"

inherit autotools

do_configure_prepend () {
	if [ ! -e acinclude.m4 ]; then
		cp aclocal.m4 acinclude.m4
	fi
}

do_install () {
	oe_runmake 'INSTALLROOT=${D}' install
}
