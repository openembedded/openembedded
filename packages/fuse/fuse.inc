DESCRIPTION = "With FUSE it is possible to implement a fully functional filesystem in a userspace program"
HOMEPAGE = "http://fuse.sf.net"
LICENSE = "GPL"
DEPENDS = "fakeroot-native"
RRECOMMENDS_fuse = "fuse-module kernel-module-fuse"

SRC_URI = "${SOURCEFORGE_MIRROR}/fuse/fuse-${PV}.tar.gz"

inherit autotools pkgconfig

fakeroot do_install() {
	oe_runmake install DESTDIR=${D}
}
