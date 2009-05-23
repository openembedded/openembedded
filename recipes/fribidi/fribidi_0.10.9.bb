DESCRIPTION = "gnu fribidi"
HOMEPAGE = "http://fribidi.org/"
SECTION = "system/libs"
LICENSE = "LGPLv2"
SRCNAME = "fribidi"
DEPENDS += " "
PV = "0.10.9"
PR = "r0"

S = "${WORKDIR}/${PN}-${PV}"
inherit autotools 

SRC_URI = "http://fribidi.org/download/fribidi-0.10.9.tar.gz"
FILES_${PN} += "${datadir} ${sysconfdir}"

do_stage() {
	autotools_stage_all
}
