DESCRIPTION = "Expedite is a comprehensive benchmarking suite for Evas"
DEPENDS = "eet evas"
LICENSE = "MIT"
PV = "0.0.0+cvs${SRCDATE}"
PR = "r1"

inherit autotools

SRC_URI = "${E_CVS};module=e17/apps/expedite \
           file://hack-disable-opengl.patch;patch=1"
S = "${WORKDIR}/${PN}"

do_configure_append() {
        find ${S} -name Makefile | xargs sed -i s:'-I$(includedir)':'-I.':g
}

FILES_${PN} += "${datadir}"

