require gypsy.inc

SRC_URI = "svn://svn.o-hand.com/repos/${PN}/trunk;module=${PN};proto=http \
           file://fixups.patch;patch=1;maxrev=107 \
           file://docs-reference-am.patch;patch=1;minrev=134 \
           file://remove-werror.patch;patch=1"
S = "${WORKDIR}/${PN}"

PV = "0.0+svnr${SRCPV}"
PR = "r1"
