DESCRIPTION = "GNU Common C++"
HOMEPAGE = "http://freshmeat.net/projects/ccrtp"
LICENSE = "GPL"
PR="r0"
DEPENDS = "commoncpp2"
SRC_URI = "ftp://ftp.gnu.org/gnu/ccrtp/ccrtp-${PV}.tar.gz \
	file://configure.ac.patch;patch=1"

inherit autotools pkgconfig autotools_stage

SRC_URI[md5sum] = "eb86cd2ac06af27ea60b1a349122605c"
SRC_URI[sha256sum] = "923cd26ffc43903ef33704e46fd57f659c3ad01554927fe323635a73082d56ae"
