DESCRIPTION = "The Enlightenment Window Manager Version 17"
DEPENDS = "eet evas ecore edje efreet edbus"
LICENSE = "MIT BSD"
SRCNAME = "e"
PV = "0.16.999.060+svnr${SRCPV}"
PR = "r13"

inherit e update-alternatives

SRC_URI += "\
  file://enlightenment_start.oe \
  file://applications.menu \
  file://gsm-segfault-fix.patch;patch=1;maxrev=37617 \
  file://fix-profiles.diff;patch=1;maxrev=39889 \
  file://drop-illume-keyboards.patch;patch=1 \
"

SRC_URI_append_openmoko = " file://illume-disable-screensaver.patch;patch=1"

SRC_URI_append_shr = " \
  file://illume-disable-screensaver.patch;patch=1 \
  file://wizard-module-skipping.patch;patch=1 \
  file://illume-flaunch-fix.patch;patch=1 \
  file://illume-keyboard-flow.patch;patch=1;maxrev=46549 \
"

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

do_install_append() {
    # customising - should rather make this simple upstream
    install -m 755 ${WORKDIR}/enlightenment_start.oe ${D}/${bindir}
    install -d ${D}/${sysconfdir}/xdg/menus
    install -m 644 ${WORKDIR}/applications.menu ${D}/${sysconfdir}/xdg/menus/
    for I in `find ${D}/${libdir}/enlightenment -name "*.a" -print`; do rm -f $I; done
    for I in `find ${D}/${libdir}/enlightenment -name "*.la" -print`; do rm -f $I; done
}

RDEPENDS_${PN} += "\
  shared-mime-info \
  mime-support \
  edje-utils \
  ${PN}-utils \
"

# Uclibc build don't have 'glibc-utils'
RDEPENDS_${PN}_append_libc-glibc = " glibc-utils "

# The systray module used to be external, but is part of e-wm now
RREPLACES_${PN} = "systray"

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
  ${PN}-sysactions \
  ${PN}-utils \
  ${PN}-menu \
"

RRECOMMENDS_${PN} = "\
  ${PN}-config-default \
  ${PN}-images \
  ${PN}-icons \
  ${PN}-other \
  ${PN}-input-methods \
  ${PN}-sysactions \
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
PACKAGE_ARCH_${PN}-sysactions = "all"
PACKAGE_ARCH_${PN}-menu = "all"

FILES_${PN} = "\
  ${bindir}/* \
  ${libdir}/enlightenment/utils/* \
  ${libdir}/enlightenment/modules/*/*.* \
  ${libdir}/enlightenment/modules/*/*/* \
  ${libdir}/enlightenment/*plugins/*/*/* \
  ${libdir}/enlightenment/preload/e_precache.so \
  ${datadir}/locale \
  ${datadir}/enlightenment/data/icons \
  ${datadir}/enlightenment/data/input_methods \
  ${datadir}/enlightenment/data/config/profile.cfg \
  ${datadir}/enlightenment/AUTHORS \
  ${datadir}/enlightenment/COPYING \
  ${datadir}/xsessions/enlightenment.desktop \
  ${sysconfdir}/xdg \
  ${datadir}/enlightenment/data/config/illume-home \
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
FILES_${PN}-sysactions = "${sysconfdir}/enlightenment/sysactions.conf"
FILES_${PN}-utils = "${libdir}/enlightenment/utils/*"
FILES_${PN}-menu = "${sysconfdir}/xdg/menus/applications.menu"

RRECOMMENDS_${PN}-config-default = "${PN}-theme-default"
RRECOMMENDS_${PN}-config-illume = "\
  ${PN}-theme-illume \
  illume-keyboard-default-alpha \
  illume-keyboard-default-numeric \
  illume-keyboard-default-terminal \
"

RRECOMMENDS_${PN}-config-minimalist = "\
  ${PN}-background-light-gradient \
  ${PN}-theme-default \
"
RRECOMMENDS_${PN}-config-netbook = "\
  ${PN}-background-dark-gradient \
  ${PN}-theme-default \
"
RRECOMMENDS_${PN}-config-scaleable = "${PN}-theme-default"
RRECOMMENDS_${PN}-config-standard = "${PN}-theme-default"

FILES_${PN}-dbg += "\
  ${libdir}/enlightenment/modules/*/*/.debug/ \
  ${libdir}/enlightenment/preload/.debug/ \
  ${libdir}/enlightenment/utils/.debug/ \
  ${libdir}/enlightenment/*plugins/*/*/.debug \
"

FILES_${PN}-doc += "\
  ${datadir}/enlightenment/doc \
"

CONFFILES_${PN}-menu = "${sysconfdir}/xdg/menus/applications.menu"
CONFFILES_${PN}-sysactions = "/etc/enlightenment/sysactions.conf"

ALTERNATIVE_PATH = "${bindir}/enlightenment_start.oe"
ALTERNATIVE_NAME = "x-window-manager"
ALTERNATIVE_LINK = "${bindir}/x-window-manager"
ALTERNATIVE_PRIORITY = "16"
