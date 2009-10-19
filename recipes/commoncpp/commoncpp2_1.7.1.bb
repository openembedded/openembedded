DESCRIPTION = "GNU Common C++"
HOMEPAGE = "http://freshmeat.net/projects/commoncpp2"
LICENSE = "GPL"
PR="r0"
SRC_URI = "ftp://ftp.gnu.org/gnu/commoncpp/commoncpp2-${PV}.tar.gz \
	file://configure.ac.patch;patch=1"

inherit autotools pkgconfig
