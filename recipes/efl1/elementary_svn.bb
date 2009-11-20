DESCRIPTION = "EFL based widget set for mobile devices"
LICENSE = "LGPL"
DEPENDS = "efreet evas ecore edje eet edbus"
PV = "0.0.0+svnr${SRCPV}"
PR = "r5"

inherit efl

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"

SRC_URI = "svn://svn.enlightenment.org/svn/e/trunk/TMP/st;module=elementary;proto=http"
S = "${WORKDIR}/elementary"

RSUGGESTS_${PN} = "elementary-tests"

do_compile_append() {
        sed -i -e s:${STAGING_DIR_TARGET}::g \
               -e s:/${TARGET_SYS}::g \
                  elementary.pc
}

FILES_${PN}-themes = "\
  ${datadir}/elementary/themes \
"

FILES_${PN}-tests = "\
  ${bindir}/elementary* \
  ${datadir}/elementary/images \
  ${datadir}/elementary/objects \
  ${datadir}/applications/* \
  ${datadir}/icons/* \
"

EXTRA_OECONF = "\
  --with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc \
"
