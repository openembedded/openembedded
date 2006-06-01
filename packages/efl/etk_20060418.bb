DESCRIPTION = "Etk is an advanced widget toolkit based on the Enlightenment Foundation Libraries."
DEPENDS = "evas-x11 ecore-x11 edje"
LICENSE = "MIT"
PR = "r1"

inherit efl

SRC_URI = "${E_CVS};module=e17/proto/etk;date=${PV}"
S = "${WORKDIR}/etk"

do_stage_append() {
        for i in src/lib/etk_*.h
        do
                install -m 0644 $i ${STAGING_INCDIR}
        done
}
