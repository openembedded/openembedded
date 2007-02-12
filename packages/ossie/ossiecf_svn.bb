DESCRIPTION = "OSSIE Core Framework"
SECTION =  "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "xerces-c omniorb libtool-cross"
PV = "0.0.0+svn${SRCDATE}"

S = "${WORKDIR}/ossie"

SRC_URI = "svn://oe:oe@ossie-dev.mprg.org/repos/ossie/ossie/trunk;module=ossie;proto=https"

inherit autotools pkgconfig

EXTRA_OECONF = "--with-omniorb=${STAGING_BINDIR}/.. IDL=${STAGING_BINDIR_NATIVE}/omniidl"

CXXFLAGS_powerpc += "-lstdc++"

do_stage () {
	autotools_stage_all
}

FILES_${PN} += "/home/sca/xml/dtd/*.dtd"

BROKEN = "1"
