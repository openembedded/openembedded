DESCRIPTION = "The Enlightenment Window Manager Version 17"
DEPENDS = "eet evas ecore edje efreet edbus"
LICENSE = "MIT BSD"
PV = "0.16.999.043+svnr${SRCREV}"
PR = "r18"

inherit e update-alternatives

RDEPENDS += "shared-mime-info mime-support edje-utils glibc-utils"

PACKAGES =+ "\
  ${PN}-config-default \
  ${PN}-config-illume \
  ${PN}-config-minimalist \
  ${PN}-config-netbook \
  ${PN}-config-scaleable \
  ${PN}-config-standard \
  ${PN}-theme-default \
  ${PN}-theme-illume \
  ${PN}-background-dark-gradient \
  ${PN}-background-light-gradient \
  ${PN}-images \
  ${PN}-icons \
  ${PN}-other \
  ${PN}-input-methods \
"

RRECOMMENDS_${PN} = "\
  ${PN}-config-default \
  ${PN}-images \
  ${PN}-icons \
  ${PN}-other \
  ${PN}-input-methods \
"

PACKAGE_ARCH_${PN}-config-default = "all"
PACKAGE_ARCH_${PN}-config-illume = "all"
PACKAGE_ARCH_${PN}-config-minimalist = "all"
PACKAGE_ARCH_${PN}-config-netbook = "all"
PACKAGE_ARCH_${PN}-config-scaleable = "all"
PACKAGE_ARCH_${PN}-config-standard = "all"
PACKAGE_ARCH_${PN}-theme-default = "all"
PACKAGE_ARCH_${PN}-theme-illume = "all"
PACKAGE_ARCH_${PN}-background-dark-gradient = "all"
PACKAGE_ARCH_${PN}-background-light-gradient = "all"
PACKAGE_ARCH_${PN}-images = "all"
PACKAGE_ARCH_${PN}-icons = "all"
PACKAGE_ARCH_${PN}-other = "all"
PACKAGE_ARCH_${PN}-input-methods = "all"

SRC_URI = "\
  svn://svn.enlightenment.org/svn/e/trunk;module=e;proto=http \
  file://enlightenment_start.oe \
  file://applications.menu \
  file://gsm-segfault-fix.patch;patch=1;maxrev=37617 \
"
S = "${WORKDIR}/e"

EXTRA_OECONF = "\
  --with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc \
  --with-eet-eet=${STAGING_BINDIR_NATIVE}/eet \
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
    for I in `find ${D}/${libdir}/enlightenment -name "*.a" -print`; do rm -f $I; done
    for I in `find ${D}/${libdir}/enlightenment -name "*.la" -print`; do rm -f $I; done
}

FILES_${PN} = "\
  ${bindir}/* \
  ${libdir}/enlightenment/modules/*/*.* \
  ${libdir}/enlightenment/modules/*/*/* \
  ${datadir}/locale \
  ${datadir}/enlightenment/data/icons \
  ${datadir}/enlightenment/data/input_methods \
  ${datadir}/enlightenment/data/config/profile.cfg \
  ${datadir}/enlightenment/AUTHORS \
  ${datadir}/enlightenment/COPYING \
  ${sysconfdir} \
"
FILES_${PN}-config-default = "${datadir}/enlightenment/data/config/default"
FILES_${PN}-config-illume = "${datadir}/enlightenment/data/config/illume"
FILES_${PN}-config-minimalist = "${datadir}/enlightenment/data/config/minimalist"
FILES_${PN}-config-netbook = "${datadir}/enlightenment/data/config/netbook"
FILES_${PN}-config-scaleable = "${datadir}/enlightenment/data/config/scaleable"
FILES_${PN}-config-standard = "${datadir}/enlightenment/data/config/standard"
FILES_${PN}-theme-default = "${datadir}/enlightenment/data/themes/default.edj"
FILES_${PN}-theme-illume = "${datadir}/enlightenment/data/themes/illume.edj"
FILES_${PN}-theme-default = "${datadir}/enlightenment/data/themes/default.edj"
FILES_${PN}-background-dark-gradient = "${datadir}/enlightenment/data/backgrounds/Dark_Gradient.edj"
FILES_${PN}-background-light-gradient = "${datadir}/enlightenment/data/backgrounds/Light_Gradient.edj"
FILES_${PN}-images = "${datadir}/enlightenment/data/images"
FILES_${PN}-icons = "${datadir}/enlightenment/data/icons"
FILES_${PN}-other = "${datadir}/enlightenment/data/other"
FILES_${PN}-input-methods = "${datadir}/enlightenment/data/input_methods"

RRECOMMENDS_${PN}-config-default = "${PN}-theme-default"
RRECOMMENDS_${PN}-config-illume = "${PN}-theme-illume"
RRECOMMENDS_${PN}-config-minimalist = "${PN}-background-light-gradient \
${PN}-theme-default"
RRECOMMENDS_${PN}-config-netbook = "${PN}-background-dark-gradient \
${PN}-theme-default"
RRECOMMENDS_${PN}-config-scaleable = "${PN}-theme-default"
RRECOMMENDS_${PN}-config-standard = "${PN}-theme-default"

FILES_${PN}-dbg += "\
  ${libdir}/enlightenment/modules/*/*/.debug/ \
  ${libdir}/enlightenment/preload/.debug/ \
"
FILES_${PN}-dev += "${libdir}/enlightenment/preload/*.?a"

CONFFILES_${PN} = "/etc/xdg/menus/applications.menu"

ALTERNATIVE_PATH = "${bindir}/enlightenment_start.oe"
ALTERNATIVE_NAME = "x-window-manager"
ALTERNATIVE_LINK = "${bindir}/x-window-manager"
ALTERNATIVE_PRIORITY = "16"
