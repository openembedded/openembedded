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

SRC_URI[md5sum] = "3c575cf89a6d3d8ab6063c2f60bd5b25"
SRC_URI[sha256sum] = "057626d78e5ade840568ab0e171a1d1ae87348ab51bf9e35d1cdc074fc4e2edb"
