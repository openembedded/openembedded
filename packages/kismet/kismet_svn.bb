require kismet.inc

DEFAULT_PREFERENCE = "-1"

PV = "2007-10-R1+svnr${SRCREV}"
FILE_PR = "r2"

SRC_URI = "svn://svn.kismetwireless.net/code/;module=trunk;proto=http"

S = "${WORKDIR}/trunk"
