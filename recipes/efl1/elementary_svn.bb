DESCRIPTION = "EFL based widget set for mobile devices"
LICENSE = "LGPL"
DEPENDS = "eet-native efreet evas ecore edje eet edbus"
PV = "0.0.0+svnr${SRCPV}"
PR = "r8"

inherit efl

EXTRA_OECONF = "\
  --with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc \
  --with-eet-eet=${STAGING_BINDIR_NATIVE}/eet \
"

SRC_URI = "svn://svn.enlightenment.org/svn/e/trunk/TMP/st;module=elementary;proto=http"
S = "${WORKDIR}/elementary"

do_compile_append() {
        sed -i -e s:${STAGING_DIR_TARGET}::g \
               -e s:/${TARGET_SYS}::g \
                  elementary.pc
}

PACKAGES =+ "${PN}-configs"

RDEPENDS_${PN} = "\
  elementary-themes \
  elementary-configs \
"
RSUGGESTS_${PN} = "elementary-tests"

FILES_${PN}-themes = "\
  ${datadir}/elementary/themes \
"

FILES_${PN}-configs = "\
  ${datadir}/elementary/config \
"

FILES_${PN}-dbg += "\
  ${libdir}/elementary/modules/test_entry/*/.debug \
"

FILES_${PN}-tests = "\
  ${bindir}/elementary* \
  ${datadir}/elementary/images \
  ${datadir}/elementary/objects \
  ${datadir}/applications/* \
  ${datadir}/icons/* \
  ${libdir}/elementary/modules/test_entry/* \
"

