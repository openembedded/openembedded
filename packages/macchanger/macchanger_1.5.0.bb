DESCRIPTION = "A GNU/Linux utility for viewing/manipulating the MAC address of network interfaces"
HOMEPAGE = "http://www.alobbs.com/modules.php?op=modload&name=macc&file=index"
MAINTAINER = "Nigel Kostiuck <emte@labotomy.net>"
LICENSE = "GPL"
SECTION = "net"
PRIORITY = "optional"

SRC_URI = "ftp://ftp.gnu.org/gnu/macchanger/macchanger-${PV}.tar.gz"

inherit autotools
