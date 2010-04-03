require kismet.inc

DEFAULT_PREFERENCE = "-1"

SRCREV = "2285"
PV = "0.0+svnr${SRCPV}"
PR = "r3"

SRC_URI = "svn://svn.kismetwireless.net/code/branch/;module=kismet-newcore;proto=http"

EXTRA_OECONF += "--disable-gpsmap"

S = "${WORKDIR}/kismet-newcore"
