require exmap-console.inc

PV = "0.4+svnr${SRCPV}"
PR = "r1"

SRC_URI = "svn://svn.o-hand.com/repos/misc/trunk;module=exmap-console;proto=http"

S = "${WORKDIR}/exmap-console"

MYPV := "${PV}"
PV_kernel-module-exmap = "${MYPV}-${KERNEL_VERSION}"
