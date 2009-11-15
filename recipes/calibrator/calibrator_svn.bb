DESCRIPTION = "The Calibrator, a Cache-Memory and TLB Calibration Tool"
HOMEPAGE = "http://monetdb.cwi.nl/Calibrator/"
LICENSE = "AS IS"

SRCREV = "21"
PV = "0.9e+svnr${SRCPV}"
PR = "r0"

SRC_URI = "svn://dev.bec-systems.com/svn/pub;module=calibrator;proto=http"

inherit autotools

S = ${WORKDIR}/calibrator

