DESCRIPTION = "EFL-based weather widget library"
LICENSE = "LGPL"
DEPENDS = "ecore edje"
PV = "0.0.0+svnr${SRCPV}"
PR = "r0"
SRCREV = "${EFL_SRCREV}"

inherit efl

EXTRA_OECONF = "--with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"

SRC_URI = "svn://svn.enlightenment.org/svn/e/trunk/PROTO;module=eweather;proto=http"
S = "${WORKDIR}/eweather"

RSUGGESTS_${PN} = "elementary-tests"

do_compile_append() {
        sed -i -e s:${STAGING_DIR_TARGET}::g \
               -e s:/${TARGET_SYS}::g \
                  eweather.pc
}

PACKAGES += "${PN}-plugins"

FILES_${PN}-themes = "\
  ${datadir} \
"

FILES_${PN}-plugins = "\
  ${libdir}/eweather/plugins/*.so \
"

FILES_${PN}-dbg += "\
  ${libdir}/eweather/plugins/.debug \
"

FILES_${PN}-dev += "\
  ${libdir}/eweather/plugins/*.a \
  ${libdir}/eweather/plugins/*.la \
"

RRECOMMENDS_${PN} = "\
  ${PN}-themes \
  ${PN}-plugins \
"
