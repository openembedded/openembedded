DESCRIPTION = "Kernel based automounter for linux."
SECTION = "base"
LICENSE = "GPL"

SRC_URI = "ftp://ftp.kernel.org/pub/linux/daemons/autofs/v4/autofs-${PV}.tar.bz2 \
	   http://www.kernel.org/pub/linux/daemons/autofs/v4/autofs-4.1.3-bad_chdir.patch;patch=1 \
	   http://www.kernel.org/pub/linux/daemons/autofs/v4/autofs-4.1.3-mtab_lock.patch;patch=1 \
	   http://www.kernel.org/pub/linux/daemons/autofs/v4/autofs-4.1.3-non_block_ping.patch;patch=1 \
	   http://www.kernel.org/pub/linux/daemons/autofs/v4/autofs-4.1.3-strict.patch;patch=1 \
	   file://cross.patch;patch=1"

inherit autotools

do_configure_prepend () {
	if [ ! -e acinclude.m4 ]; then
		cp aclocal.m4 acinclude.m4
	fi
}

do_install () {
	oe_runmake 'INSTALLROOT=${D}' install
}
