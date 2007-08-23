DESCRIPTION = "Expedite is a comprehensive benchmarking suite for evas"
DEPENDS = "evas"
LICENSE = "MIT"
PV = "0.0.0+cvs${SRCDATE}"
PR = "r0"

inherit e

SRC_URI = "${E_CVS};module=e17/apps/expedite"
S = "${WORKDIR}/${PN}"

do_configure_append() {
        find ${S} -name Makefile | xargs sed -i s:'-I$(includedir)':'-I.':g
}

