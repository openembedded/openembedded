DESCRIPTION = "An EFL based Alarm app"
LICENSE = "MIT BSD"
DEPENDS = "evas ecore edje eet edbus"
PV = "0.0.0+svnr${SRCREV}"
PR = "r0.23"

inherit efl

RDEPENDS += "elementary-themes"

RRECOMMENDS_${PN} += "elementary-tests"

SRC_URI = "svn://svn.enlightenment.org/svn/e/trunk/TMP/st;module=elementary;proto=http"
S = "${WORKDIR}/elementary"
PACKAGES =+ "${PN}-tests"

FILES_${PN}-themes = "\
  ${datadir}/elementary/themes \
"

FILES_${PN}-tests = "\
  ${bindir}/elementary* \
  ${datadir}/elementary/images \
  ${datadir}/elementary/objects \
"
