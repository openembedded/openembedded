DESCRIPTION = "GNU Common C++"
HOMEPAGE = "http://freshmeat.net/projects/commoncpp2"
LICENSE = "GPL"
PR="r2"
PARALLEL_MAKE = ""

SRC_URI = "ftp://ftp.gnu.org/gnu/commoncpp/commoncpp2-${PV}.tar.gz \
	file://configure.ac.patch;patch=1"

inherit autotools pkgconfig autotools_stage binconfig

SRC_URI[md5sum] = "e1041356c3129e4d3d3d6a44f281d905"
SRC_URI[sha256sum] = "cc0a7b96fd103154de70e8abfa5c5e3a6c8b9f5ca88f78aada4885c92ae089ba"
