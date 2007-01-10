DESCRIPTION = "OSSIE Standard port interfaces"
SECTION =  "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
PV = "0.0.0+svn${SRCDATE}"
PR = "r0"

DEPENDS = "ossiecf"

S="${WORKDIR}/standardInterfaces"

SRCDATE = "now"
SRC_URI = "svn://ossie-dev.mprg.org/repos/ossie/standardInterfaces/trunk;module=standardInterfaces;proto=https"

inherit autotools pkgconfig

EXTRA_OECONF = "--with-omniorb=${STAGING_BINDIR}/.. IDL=${STAGING_BINDIR_NATIVE}/omniidl"

CXXFLAGS_powerpc += "-lstdc++"

do_stage () {
	autotools_stage_all
}
BROKEN = "1"
