DESCRIPTION = "An EFL based Alarm app"
LICENSE = "MIT BSD"
DEPENDS = "evas ecore edje eet edbus"
PV = "0.0.0+svnr${SRCREV}"
PR = "r1"

inherit efl

SRC_URI = "svn://svn.enlightenment.org/svn/e/trunk/TMP/st;module=elementary;proto=http"
S = "${WORKDIR}/elementary"

RDEPENDS = "elementary-themes"
RRECOMMENDS = "elementary-tests"

FILES_${PN}-themes = "\
  ${datadir}/elementary/themes \
"

FILES_${PN}-tests = "\
  ${bindir}/elementary* \
  ${datadir}/elementary/images \
  ${datadir}/elementary/objects \
"
