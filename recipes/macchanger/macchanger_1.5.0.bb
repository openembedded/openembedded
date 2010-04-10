DESCRIPTION = "A GNU/Linux utility for viewing/manipulating the MAC address of network interfaces"
HOMEPAGE = "http://www.alobbs.com/modules.php?op=modload&name=macc&file=index"
LICENSE = "GPL"
SECTION = "net"
PRIORITY = "optional"

SRC_URI = "ftp://ftp.gnu.org/gnu/macchanger/macchanger-${PV}.tar.gz"

inherit autotools

SRC_URI[md5sum] = "79b7cdaeca3d8ebafa764c4b0dd03ab7"
SRC_URI[sha256sum] = "d44bfa27cb29c5a718627cb3ef3aa42eb5130426545eb2031120826cd73fa8fe"
