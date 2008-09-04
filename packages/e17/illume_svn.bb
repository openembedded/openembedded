DESCRIPTION = "Illume - A mobile UI module for the Enlightenment Window Manager"
HOMEPAGE = "http://illume.projects.openmoko.org"
AUTHOR = "Carsten 'Rasterman' Haitzler"
LICENSE = "MIT/BSD"
DEPENDS = "e-wm eet evas ecore edje embryo efreet edbus edje-native embryo-native eet-native"
PV = "0.0+svnr${SRCREV}"
PR = "r13"

SRC_URI = "svn://svn.enlightenment.org/svn/e/trunk;module=illume;proto=http"
S = "${WORKDIR}/${PN}"

inherit autotools pkgconfig

EXTRA_OECONF = "\
  --x-includes=${STAGING_INCDIR}/X11 \
  --x-libraries=${STAGING_LIBDIR} \
  --enable-simple-x11 \
  --with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc \
  --with-eet-eet=${STAGING_BINDIR_NATIVE}/eet \
"

RRECOMMENDS_${PN} = "\
  ${PN}-config-illume \
  ${PN}-theme \
  ${PN}-dicts-english-us \
  ${PN}-keyboards-default \
  ${PN}-keyboards-numbers \
  ${PN}-keyboards-terminal \
"

PACKAGES =+ "\
  ${PN}-config-illume \
  ${PN}-config-asu \
  ${PN}-dicts-english-us \
  ${PN}-keyboards-default \
  ${PN}-keyboards-numbers \
  ${PN}-keyboards-terminal \
"
PACKAGE_ARCH_${PN}-config-illume = "all"
PACKAGE_ARCH_${PN}-config-asu = "all"
PACKAGE_ARCH_${PN}-dicts-english-us = "all"
PACKAGE_ARCH_${PN}-keyboards-default = "all"
PACKAGE_ARCH_${PN}-keyboards-numbers = "all"
PACKAGE_ARCH_${PN}-keyboards-terminal = "all"

FILES_${PN}-config-illume = "${datadir}/enlightenment/data/config/illume/*"
FILES_${PN}-config-asu = "${datadir}/enlightenment/data/config/asu/*"
FILES_${PN}-dicts-english-us = "${libdir}/enlightenment/modules/illume/dicts/English_*.dic"
FILES_${PN}-keyboards-default = "${libdir}/enlightenment/modules/illume/keyboards/Default.kbd"
FILES_${PN}-keyboards-numbers = "${libdir}/enlightenment/modules/illume/keyboards/Numbers.kbd"
FILES_${PN}-keyboards-terminal = "${libdir}/enlightenment/modules/illume/keyboards/Terminal.kbd"

FILES_${PN} = "\
  ${libdir}/enlightenment/modules/*/*.edj \
  ${libdir}/enlightenment/modules/*/*.desktop \
  ${libdir}/enlightenment/modules/*/*/* \
"
FILES_${PN}-dbg += "${libdir}/enlightenment/modules/*/*/.debug/"
