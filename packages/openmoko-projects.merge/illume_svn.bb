DESCRIPTION = "Illume - Mobile UI module for Enlightenment"
DEPENDS = "e-wm eet evas ecore edje embryo efreet edbus edje-native embryo-native"
LICENSE = "MIT BSD"
PV = "svnr${SRCREV}"
PR = "r1"

inherit e

SRC_URI = "svn://svn.projects.openmoko.org/svnroot/;module=${PN};proto=https \
           file://include-path.diff;patch=1"
S = "${WORKDIR}/${PN}"

EXTRA_OECONF = "--x-includes=${STAGING_INCDIR}/X11 \
                --x-libraries=${STAGING_LIBDIR} \
		--enable-simple-x11 \
                --with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"
                
FILES_${PN} = "${libdir}/enlightenment/modules/*/*.edj ${libdir}/enlightenment/modules/*/*.desktop ${libdir}/enlightenment/modules/*/*/*"
FILES_${PN}-dbg += "${libdir}/enlightenment/modules/*/*/.debug/"

do_install_append() {
  for I in `find ${STAGING_LIBDIR}/enlightenment -name "*.la" -print`; do rm -f $I; done
  for I in `find ${STAGING_LIBDIR}/enlightenment -name "*.a" -print`; do rm -f $I; done
  for I in `find ${STAGING_LIBDIR_CROSS}/enlightenment -name "*.la" -print`; do rm -f $I; done
  for I in `find ${STAGING_LIBDIR_CROSS}/enlightenment -name "*.a" -print`; do rm -f $I; done
}
