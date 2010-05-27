DESCRIPTION = "Synthesis SyncML Engine"
SRC_URI = "git://git.moblin.org/${PN}.git;protocol=git"
LICENSE = "LGPLv2.1"
SRCREV = "70f0065aa3b085bdf059830f95e5b5766eecb0bb"
PV = "0.0+git${SRCREV}"
PR = "r1"

DEPENDS = "libpcre"

S = "${WORKDIR}/git"

inherit autotools_stage

do_configure_prepend () {
	cd ${S}/src
	${S}/src/gen-makefile-am.sh
	cd ${S}
}

