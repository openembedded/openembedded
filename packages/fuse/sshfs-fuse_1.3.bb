HOMEPAGE = "http://fuse.sourceforge.net/sshfs.html"
DESCRIPTION = "This is a filesystem client based on the SSH File Transfer Protocol using FUSE."
MAINTAINER = "Koen Kooi <koen@handhelds.org>"

LICENSE_${PN} = "LGPL"

DEPENDS = "fakeroot-native fuse" 
RRECOMMENDS_${PN} = "fuse-module"

SRC_URI="${SOURCEFORGE_MIRROR}/fuse/${P}.tar.gz"

inherit autotools pkgconfig


