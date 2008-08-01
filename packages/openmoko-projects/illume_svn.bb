DESCRIPTION = "Illume - A mobile UI module for the Enlightenment Window Manager"
HOMEPAGE = "http://illume.projects.openmoko.org"
AUTHOR = "Rasterman"
LICENSE = "MIT/BSD"
DEPENDS = "e-wm eet evas ecore edje embryo efreet edbus edje-native embryo-native eet-native"
PV = "0.0+svnr${SRCREV}"
PR = "r11"

SRC_URI = "\
  svn://svn.projects.openmoko.org/svnroot/;module=${PN};proto=http \
  file://configure-keyboard.patch;patch=1;pnum=0;maxrev=170 \
  file://module.illume.src \
"
S = "${WORKDIR}/${PN}"

inherit autotools pkgconfig

EXTRA_OECONF = "\
  --x-includes=${STAGING_INCDIR}/X11 \
  --x-libraries=${STAGING_LIBDIR} \
  --enable-simple-x11 \
  --with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc \
  --with-eet-eet=${STAGING_BINDIR_NATIVE}/eet \
\
  --enable-illume-keyboard \
"

RRECOMMENDS_${PN} = "\
  wamerican \
  ${PN}-config \
  ${PN}-theme \
  ${PN}-dicts-default \
  ${PN}-keyboards-default \
  ${PN}-keyboards-numbers \
"

PACKAGES =+ "\
  ${PN}-config \
  ${PN}-dicts-default \
  ${PN}-keyboards-default \
  ${PN}-keyboards-numbers \
"
PACKAGE_ARCH_${PN}-config = "all"
PACKAGE_ARCH_${PN}-dicts-default = "all"
PACKAGE_ARCH_${PN}-keyboards-default = "all"
PACKAGE_ARCH_${PN}-keyboards-numbers = "all"

FILES_${PN}-config = "${datadir}/enlightenment/data/config/*/* ${datadir}/illume"
FILES_${PN}-dicts-default = "${libdir}/enlightenment/modules/illume/dicts/Default.dic"
FILES_${PN}-keyboards-default = "${libdir}/enlightenment/modules/illume/keyboards/Default.kbd"
FILES_${PN}-keyboards-numbers = "${libdir}/enlightenment/modules/illume/keyboards/Numbers.kbd"

FILES_${PN} = "\
  ${libdir}/enlightenment/modules/*/*.edj \
  ${libdir}/enlightenment/modules/*/*.desktop \
  ${libdir}/enlightenment/modules/*/*/* \
"
FILES_${PN}-dbg += "${libdir}/enlightenment/modules/*/*/.debug/"

do_configure_append() {
  mv ${WORKDIR}/module.illume.src ${S}/config/illume/
}
