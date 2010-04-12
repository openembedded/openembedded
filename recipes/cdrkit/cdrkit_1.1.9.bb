# cdrkit build file

LICENSE="GPLv2"
DESCRIPTION="A set of tools for CD recording"
HOMEPAGE="http://www.cdrkit.org"

PARALLEL_MAKE = ""
DEPENDS = "libcap"
SRC_URI="http://cdrkit.org/releases/cdrkit-${PV}.tar.gz \
	file://xconfig.patch;patch=1"

S="${WORKDIR}/cdrkit-${PV}"
PR = "r2"

inherit cmake 

do_install() {
	oe_runmake install DESTDIR="${D}"
}

SRC_URI[md5sum] = "cbc0647e5d85f0e8fb3a692ba1d42edd"
SRC_URI[sha256sum] = "d5d58ab4c7bef036a53ef9742b4e57621f61310cd0cd28f558ba0b88c354efa2"
