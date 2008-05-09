DESCRIPTION = "This is a filesystem client based on the FTP File Transfer Protocol using FUSE."
AUTHOR = "Robson Braga Araujo - <brag@users.sf.net>"
HOMEPAGE = "http://curlftpfs.sourceforge.net/"
SECTION = "console/network"
PRIORITY = "optional"
LICENSE = "GPLv2"
DEPENDS = "glib-2.0 fuse curl"
RDEPENDS += " libcurl "
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/curlftpfs/${P}.tar.gz"

S = "${WORKDIR}/${P}"

inherit autotools
