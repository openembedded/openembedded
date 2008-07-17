DESCRIPTION = "Illume - Mobile UI module for Enlightenment"
HOMEPAGE = "http://illume.projects.openmoko.org/"
LICENSE = "MIT/BSD"
DEPENDS = "e-wm eet evas ecore edje embryo efreet edbus edje-native embryo-native"
RRECOMMENDS = "wamerican"
PV = "0.0+svnr${SRCREV}"
PR = "r6"

SRC_URI = "svn://svn.projects.openmoko.org/svnroot/;module=${PN};proto=https"

S = "${WORKDIR}/${PN}"

inherit autotools pkgconfig

EXTRA_OECONF = "--x-includes=${STAGING_INCDIR}/X11 \
                --x-libraries=${STAGING_LIBDIR} \
                --enable-simple-x11 \
                --with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"

FILES_${PN} = "${libdir}/enlightenment/modules/*/*.edj \
               ${libdir}/enlightenment/modules/*/*.desktop \
               ${libdir}/enlightenment/modules/*/*/* \
               ${datadir}/enlightenment/data/config/*/* \
               ${datadir}/${PN} "
FILES_${PN}-dbg += "${libdir}/enlightenment/modules/*/*/.debug/"
