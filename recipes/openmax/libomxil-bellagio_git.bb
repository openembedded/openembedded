require ${PN}.inc

PR = "${INC_PR}.0"

SRCREV = "772f0eca88b242ffb5469e8e381c63ce1f7cd3e1"
SRC_URI = "git://omxil.git.sourceforge.net/gitroot/omxil/omxil;protocol=git"
SRC_URI += " \
	file://0001-configure.ac-remove-Werror-from-CFLAGS.patch \
"
PV = "0.9.2.1"
PR = "${INC_PR}.0"
PR_append = "+gitr${SRCPV}"

S = "${WORKDIR}/git"
