require wxwidgets.inc

PR = "r0"

LEAD_SONAME = "libwx_gtk2_core-2.8.so"

do_stage() {
       install -d ${STAGING_INCDIR}/wx-2.8/wx
       cp -pR include/wx ${STAGING_INCDIR}/wx-2.8
       cp -pR lib/libwx* ${STAGING_LIBDIR}
       cp -pR lib/wx     ${STAGING_LIBDIR}
       cp -pR build/bakefiles/wxpresets/presets  ${STAGING_DATADIR}/bakefile
       cp -pR wxwin.m4                           ${STAGING_DATADIR}/aclocal
       ln -sf ${STAGING_LIBDIR}/wx/config/${TARGET_PREFIX}gtk2-ansi-release-2.8 ${STAGING_BINDIR_CROSS}/wx-config
       sed -e s,'wxconfdir=".*"','wxconfigdir="${STAGING_LIBDIR}/wx/config"', \
           -e s,'bindir=".*"','bindir="${STAGING_BINDIR}"', \
           -e s,'libdir=".*"','libdir="${STAGING_LIBDIR}"', \
           -e s,'includedir=".*"','includedir="${STAGING_INCDIR}"', \
           -i ${STAGING_LIBDIR}/wx/config/${TARGET_PREFIX}gtk2-ansi-release-2.8
}

do_install() {
       oe_runmake 'DESTDIR=${D}' install
       ln -sf  ${libdir}/wx/config/${TARGET_PREFIX}gtk2-ansi-release-2.8 ${D}${bindir}/wx-config
}
