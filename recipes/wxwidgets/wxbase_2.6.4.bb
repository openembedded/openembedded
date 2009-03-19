require wxbase.inc

PR = "r0"

EXTRA_OECONF = "--enable-largefile"

LEAD_SONAME = "libwx_base-2.6.so"

do_stage() {
       install -d ${STAGING_INCDIR}/wx-2.6/wx
       cp -pR include/wx ${STAGING_INCDIR}/wx-2.6
       cp -pR lib/libwx* ${STAGING_LIBDIR}
       cp -pR lib/wx     ${STAGING_LIBDIR}
       cp -pR build/bakefiles/wxpresets/presets  ${STAGING_DATADIR}/bakefile
       cp -pR wxwin.m4                           ${STAGING_DATADIR}/aclocal
       ln -sf ${STAGING_LIBDIR}/wx/config/${TARGET_PREFIX}base-ansi-release-2.6 ${STAGING_BINDIR_CROSS}/wx-config
       sed -e s,'wxconfdir=".*"','wxconfigdir="${STAGING_LIBDIR}/wx/config"', \
           -e s,'bindir=".*"','bindir="${STAGING_BINDIR}"', \
           -e s,'libdir=".*"','libdir="${STAGING_LIBDIR}"', \
           -e s,'includedir=".*"','includedir="${STAGING_INCDIR}"', \
           -i ${STAGING_LIBDIR}/wx/config/${TARGET_PREFIX}base-ansi-release-2.6
}

FILES_${PN} += "${libdir}/wx/config"
FILES_${PN}-dev += "${libdir}/wx/include ${datadir}/bakefile"

do_install() {
       oe_runmake 'DESTDIR=${D}' install
       ln -sf  ${libdir}/wx/config/${TARGET_PREFIX}base-ansi-release-2.6 ${D}${bindir}/wx-config
       install -d ${D}${docdir}/${PN}-${PV}
       install -m 644 -p CHANGES.txt     ${D}${docdir}/${PN}-${PV}
       install -m 644 -p COPYING.LIB     ${D}${docdir}/${PN}-${PV}
       install -m 644 -p LICENCE.txt     ${D}${docdir}/${PN}-${PV}
       install -m 644 -p README.txt      ${D}${docdir}/${PN}-${PV}
}
