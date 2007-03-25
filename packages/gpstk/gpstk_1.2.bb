DESCRIPTION = "Libraries and applications to facilitate working with GPS data for research and high accuracy uses."
HOMEPAGE = "http://www.gpstk.org/"
LICENSE = "LGPL"
SECTION = "libs"

SRC_URI = "${SOURCEFORGE_MIRROR}/gpstk/gpstk-${PV}-src.tar.gz \
	   file://configure.patch;patch=1"

inherit autotools lib_package

do_stage() {
    autotools_stage_all
}
