SECTION = "console/network"
DEPENDS = "ncurses"
LICENSE = "GPL"
SRC_URI = "http://alioth.debian.org/download.php/123/minicom-${PV}.tar.gz \
	file://configure.patch;patch=1 \
	file://gcc4-scope.patch;patch=1 \
	file://gcc4-scope2.patch;patch=1"

inherit autotools gettext

do_install() {
	for d in doc extras man intl lib src; do make -C $d DESTDIR=${D} install; done
}

SRC_URI[md5sum] = "1c8f3b247c38fb16c3c2170df9fc102a"
SRC_URI[sha256sum] = "7f04535b3839fbbb0affa780108c32c330b924caf4e41dacd57dd23aa1fec392"
