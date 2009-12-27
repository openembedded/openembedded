require ${PN}.inc

PV = "${OPIE_GIT_PV}"
PR = "r4"

SRC_URI = "${OPIE_GIT};protocol=git;subpath=core/opiealarm \
           file://01opiealarm \
	   file://dirdefines-2.patch "
