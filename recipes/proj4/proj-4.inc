DESCRIPTION = "PROJ.4 - Cartographic Projections Library"
HOMEPAGE = "http://www.remotesensing.org/proj/"
LICENSE = "MIT"

PR = "r1"

inherit autotools pkgconfig

SRC_URI = "ftp://ftp.remotesensing.org/proj/proj-4.${PV}.tar.gz"

S = "${WORKDIR}/proj-4.${PV}"

FILES_${PN} += "${datadir}/proj"

do_stage() {
	autotools_stage_all
}

