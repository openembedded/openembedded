DESCRIPTION = "The Enlightenment Window Mananger Version 17"
DEPENDS = "eet evas ecore edje efreet edbus"
LICENSE = "MIT BSD"
PV = "0.16.999.042+cvs${SRCDATE}"
PR = "r9"

inherit e update-alternatives

RDEPENDS += "shared-mime-info mime-support"

SRC_URI = "${E_CVS};module=e17/apps/e \
           file://disable-e-cursor.patch;patch=1 \
           file://pkgconfig-fix.patch;patch=1;pnum=0;mindate=20080328;maxdate=20080401 \
           file://profile-search.patch;patch=1;mindate=20080328;maxdate=20080401 \
           file://enlightenment_start.oe \
           file://applications.menu \
"
S = "${WORKDIR}/e"

EXTRA_OECONF = "\
  --with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc \
  --x-includes=${STAGING_INCDIR}/X11 \
  --x-libraries=${STAGING_LIBDIR} \
  --enable-simple-x11 \
"

do_configure_prepend() {
	autopoint
}

do_stage() {
    autotools_stage_all
    for I in `find ${STAGING_LIBDIR}/enlightenment -name "*.la" -print`; do rm -f $I; done
    for I in `find ${STAGING_LIBDIR}/enlightenment -name "*.a" -print`; do rm -f $I; done
    for I in `find ${STAGING_LIBDIR_CROSS}/enlightenment -name "*.la" -print`; do rm -f $I; done
    for I in `find ${STAGING_LIBDIR_CROSS}/enlightenment -name "*.a" -print`; do rm -f $I; done
}

do_install_append() {
    # customising - should rather make this simple upstream
    install -m 755 ${WORKDIR}/enlightenment_start.oe ${D}/${bindir}
    install -d ${D}/${sysconfdir}/xdg/menus
    install -m 644 ${WORKDIR}/applications.menu ${D}/${sysconfdir}/xdg/menus/
}

FILES_${PN} = "\
  ${bindir}/* \
  ${libdir}/enlightenment/modules/*/*.* \
  ${libdir}/enlightenment/modules/*/*/* \
  ${libdir}/enlightenment/preload/*.so \
  ${datadir} \
  ${sysconfdir} \
"
FILES_${PN}-dbg += "\
  ${libdir}/enlightenment/modules/*/*/.debug/ \
  ${libdir}/enlightenment/preload/.debug/ \
"

FILES_${PN}-dev += "\
  ${libdir}/enlightenment/preload/*.?a \
"

CONFFILES_${PN} = "/etc/xdg/menus/applications.menu"

ALTERNATIVE_PATH = "${bindir}/enlightenment_start.oe"
ALTERNATIVE_NAME = "x-window-manager"
ALTERNATIVE_LINK = "${bindir}/x-window-manager"
ALTERNATIVE_PRIORITY = "16"
