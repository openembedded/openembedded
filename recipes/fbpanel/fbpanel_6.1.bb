DESCRIPTION = "A gtk based panel application"
SECTION = "x11"
LICENSE = "GPLv2"
DEPENDS = "gtk+ libxmu libxpm"
HOMEPAGE = "http://fbpanel.sourceforge.net/"
SRC_URI = "${SOURCEFORGE_MIRROR}/fbpanel/fbpanel-${PV}.tbz2"

PR = "r0"

do_configure () {
	./configure --prefix=${prefix}
}

do_install () {
	oe_runmake install DESTDIR=${D}
}

SRC_URI[md5sum] = "80ca0c64195b30587cfcb8c2cd9887a0"
SRC_URI[sha256sum] = "e14542cc81ea06e64dd4708546f5fd3f5e01884c3e4617885c7ef22af8cf3965"
