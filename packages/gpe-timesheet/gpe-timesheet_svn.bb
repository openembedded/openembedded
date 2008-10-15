require gpe-timesheet.inc

FILE_PR = "r1"
PV = "0.31+svn-${SRCDATE}"

SRC_URI = "${GPE_SVN}"

S = "${WORKDIR}/${PN}"

DEFAULT_PREFERENCE = "-1"
