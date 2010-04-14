DESCRIPTION = "Acceleration library for ATI imageon chipsets (w100 and w3220)"
LICENSE = "GPLv2"

SRCREV = "60"
SRC_URI = "svn://libw100.svn.sourceforge.net/svnroot/libw100/tags;module=rev_0_0_2;proto=https"

S = "${WORKDIR}/rev_0_0_2"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}

