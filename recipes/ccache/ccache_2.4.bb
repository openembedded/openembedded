DESCRIPTION = "compiler cache"
HOMEPAGE = "http:/ccache.samba.org"
SECTION = "devel"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://samba.org/ftp/ccache/ccache-${PV}.tar.gz \
	file://ccache-gcov.patch;patch=1 \
	"

inherit autotools
