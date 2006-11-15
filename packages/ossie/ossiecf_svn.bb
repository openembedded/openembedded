PR = "r0"
DESCRIPTION = "OSSIE Core Framework"
SECTION =  "libs"
PRIORITY = "optional"
LICENSE = "LGPL"

DEPENDS = "xerces-c omniorb libtool-cross"

S="${WORKDIR}/ossie"

SRC_URI = "svn://ossie-dev.mprg.org/repos/ossie/ossie/trunk;module=ossie;proto=https"

inherit autotools pkgconfig

do_stage () {
	autotools_stage_all
}

FILES_${PN} += "/home/sca/xml/dtd/*.dtd"

BROKEN = "1"
