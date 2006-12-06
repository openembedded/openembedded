PR = "r0"
DESCRIPTION = "OSSIE Signal Processing routines"
SECTION =  "libs"
PRIORITY = "optional"
LICENSE = "LGPL"

DEPENDS = "ossiecf"

S="${WORKDIR}/SigProc"

SRCDATE = "now"
SRC_URI = "svn://oe:oe@ossie-dev.mprg.org/repos/ossie/SigProc/trunk;module=SigProc;proto=https"

inherit autotools pkgconfig

EXTRA_OECONF_append_arm = " --enable-fpm=arm"

do_stage () {
	autotools_stage_all
}
BROKEN = "1"
