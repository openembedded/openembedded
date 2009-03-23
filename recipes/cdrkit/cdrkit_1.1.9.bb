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
