require cgreen.inc

SRCREV = "334"
PR = "${INC_PR}.0"

S = "${WORKDIR}/cgreen"

SRC_URI = "svn://cgreen.svn.sourceforge.net/svnroot/cgreen/trunk;module=cgreen;proto=https"

EXTRA_OECONF = ""
EXTRA_OEMAKE = "INSTALL_PREFIX=${D}"

EXTRA_OECMAKE = ""

OECMAKE_SOURCEPATH = "../cgreen"
