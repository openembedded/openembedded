DESCRIPTION = "GNU Common C++"
HOMEPAGE = "http://freshmeat.net/projects/ccrtp"
LICENSE = "GPL"
PR="r0"
DEPENDS = "commoncpp2"
SRC_URI = "ftp://ftp.gnu.org/gnu/ccrtp/ccrtp-${PV}.tar.gz \
	file://configure.ac.patch;patch=1"

inherit autotools pkgconfig autotools_stage
