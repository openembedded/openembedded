DESCRIPTION = "This is a filesystem client based on the SSH File Transfer Protocol using FUSE."
AUTHOR = "Miklos Szeredi <miklos@szeredi.hu>"
HOMEPAGE = "http://fuse.sourceforge.net/sshfs.html"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPLv2"
DEPENDS = "glib-2.0 fuse"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/fuse/${P}.tar.gz"
S = "${WORKDIR}/${P}"

inherit autotools

FILES_${PN} += "${libdir}/sshnodelay.so"

SRC_URI[md5sum] = "26e9206eb5169e87e6f95f54bc005a4f"
SRC_URI[sha256sum] = "206ebcbc4cb9f5039bfcc7059678a0f61120605a5cdcbffa3ae5716c113e5423"
