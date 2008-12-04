DESCRIPTION = "mount UPnP server content as a linux filesystem"
HOMEPAGE = "http://djmount.sourceforge.net/"
LICENSE = "GPL"
DEPENDS = "libupnp fuse"
RDEPENDS = "fuse-utils fuse-module"
PR = "r1"

INITSCRIPT_NAME = "djmount"
INITSCRIPT_PARAMS = "defaults"

inherit autotools update-rc.d

EXTRA_OECONF = "--with-external-libupnp --with-fuse-prefix='/usr/lib/'"

SRC_URI = "${SOURCEFORGE_MIRROR}/djmount/djmount-0.71.tar.gz \
	file://init"

do_install_append() {
	install -d ${D}/etc/init.d
	install -m 0755 ${WORKDIR}/init ${D}/etc/init.d/djmount
}
