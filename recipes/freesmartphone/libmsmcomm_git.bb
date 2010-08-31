require msmcomm.inc

PR = "${INC_PR}.0"
PV = "0.5.0+gitr${SRCPV}"

S = "${WORKDIR}/git/libmsmcomm"

inherit autotools
