require msmcomm.inc

PR = "${INC_PR}.0"
PV = "0.1.0+gitr${SRCPV}"

S = "${WORKDIR}/git/${PN}"

inherit autotools
