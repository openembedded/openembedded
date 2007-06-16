inherit e

DEPENDS = "evas-x11"

PV = "0.0+cvs${SRCDATE}"

SRC_URI = "cvs://anonymous@anoncvs.enlightenment.org/var/cvs/e;module=e17/apps/expedite"

S = "${WORKDIR}/${PN}"

do_configure_append() {
        find ${S} -name Makefile | xargs sed -i s:'-I$(includedir)':'-I.':g
}

