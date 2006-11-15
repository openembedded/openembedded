PR = "r0"
DESCRIPTION = "OSSIE Standard port interfaces"
SECTION =  "libs"
PRIORITY = "optional"
LICENSE = "LGPL"

DEPENDS = "ossiecf"

S="${WORKDIR}/standardInterfaces"

SRCDATE = "now"
SRC_URI = "svn://ossie-dev.mprg.org/repos/ossie/standardInterfaces/trunk;module=standardInterfaces;proto=https"

inherit autotools pkgconfig

do_stage () {
	autotools_stage_all
}
BROKEN = "1"
