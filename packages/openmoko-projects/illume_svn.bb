DESCRIPTION = "Illume - Mobile UI module for Enlightenment"
HOMEPAGE = "http://illume.projects.openmoko.org/"
LICENSE = "MIT/BSD"

DEPENDS = "e-wm eet evas ecore edje embryo efreet edbus edje-native embryo-native"

PV = "0.0+svnr${SRCREV}"
PR = "r1"

SRC_URI = "svn://svn.projects.openmoko.org/svnroot/;module=${PN};proto=https \
	   file://illume-fix-includes.patch;patch=1;pnum=0;minrev=14"

S = "${WORKDIR}/${PN}"

inherit autotools pkgconfig

EXTRA_OECONF = "--x-includes=${STAGING_INCDIR}/X11 \
                --x-libraries=${STAGING_LIBDIR} \
		--enable-simple-x11 \
                --with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"

export CFLAGS += "-DE_TYPEDEFS=1"

do_configure_append() {
  find ${S} -name Makefile | xargs sed -i 's:/usr/include:${STAGING_INCDIR}:'
  find ${S} -name Makefile | xargs sed -i 's:/usr/X11R6/include:${STAGING_INCDIR}:'
}

FILES_${PN} = "${libdir}/enlightenment/modules/*/*.edj \
               ${libdir}/enlightenment/modules/*/*.desktop \
               ${libdir}/enlightenment/modules/*/*/*"

FILES_${PN}-dbg += "${libdir}/enlightenment/modules/*/*/.debug/"
