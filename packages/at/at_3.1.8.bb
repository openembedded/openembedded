DEPENDS = "flex"
DESCRIPTION = "Delayed job execution and batch processing."
SECTION = "base"
LICENSE="BSD"

SRC_URI = "${DEBIAN_MIRROR}/main/a/at/at_${PV}-11.tar.gz \
	   file://configure.patch;patch=1 \
	   file://nonrootinstall.patch;patch=1"

inherit autotools

export LIBS = "-L${STAGING_LIBDIR}"

do_install () {
	oe_runmake 'IROOT=${D}' install
}
