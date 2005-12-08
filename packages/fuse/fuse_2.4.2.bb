HOMEPAGE = "http://fuse.sf.net"
DESCRIPTION = "With FUSE it is possible to implement a fully functional filesystem in a userspace program"
MAINTAINER = "Koen Kooi <koen@handhelds.org>"

LICENSE_${PN} = "LGPL"

DEPENDS = "fakeroot-native"
RRECOMMENDS_${PN} = "fuse-module"

SRC_URI="${SOURCEFORGE_MIRROR}/fuse/${P}.tar.gz"

inherit autotools pkgconfig
EXTRA_OECONF = " --disable-kernel-module"

fakeroot do_install() {
oe_runmake install DESTDIR=${D}
}

fakeroot do_stage() {
autotools_stage_all
}


