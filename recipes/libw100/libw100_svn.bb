DESCRIPTION = "Acceleration library for ATI imageon chipsets (w100 and w3220)"
LICENSE = "GPLv2"

PV = "0.0.2+svnr${SRCPV}"
PE = "1"
SRC_URI = "svn://libw100.svn.sourceforge.net/svnroot/libw100;module=trunk;proto=https"

S = "${WORKDIR}/trunk"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}

