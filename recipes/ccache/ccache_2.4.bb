DESCRIPTION = "compiler cache"
HOMEPAGE = "http:/ccache.samba.org"
SECTION = "devel"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://samba.org/ftp/ccache/ccache-${PV}.tar.gz \
	file://ccache-gcov.patch;patch=1 \
	"

inherit autotools

SRC_URI[md5sum] = "73c1ed1e767c1752dd0f548ec1e66ce7"
SRC_URI[sha256sum] = "435f862ca5168c346f5aa9e242174bbf19a5abcaeecfceeac2f194558827aaa0"
