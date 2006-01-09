DESCRIPTION = "A minimal version of the Mozilla web browser"
HOMEPAGE="http://www.mozilla.org/projects/minimo/"
SRC_URI = "cvs://anonymous@cvs-mirror.mozilla.org/cvsroot;module=mozilla \
	   file://no-xmb.patch;patch=1 \
	   file://host_ldflags_fix.patch;patch=1 \
	   file://minimo.png file://minimo.desktop"
S = "${WORKDIR}/mozilla"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
SECTION = "x11"
PRIORITY = "optional"
PV = "0.0+cvs${SRCDATE}"
FILES_${PN} += "${libdir}/mozilla-minimo"
PR = "r8"
LICENSE = "MPL/LGPL/GPL"

inherit mozilla

EXTRA_OECONF += "--enable-application=minimo --disable-native-uconv"
export MOZ_CO_PROJECT="minimo"

export MINIMO=1
export MOZ_OBJDIR="${WORKDIR}/build-${TARGET_SYS}"

include mozilla-cvs.inc

do_compile () {
	mozilla_do_compile
}

mozdir="${D}${libdir}/mozilla-minimo"

do_install () {
	cd $MOZ_OBJDIR/minimo/base
	oe_runmake package
	cd ${S}
	mkdir -p ${mozdir}
	cp -rL $MOZ_OBJDIR/dist/minimo/* ${mozdir}/
	mkdir -p ${D}${datadir}/applications
	install -m 0644 ${WORKDIR}/minimo.desktop ${D}${datadir}/applications/minimo.desktop
	mkdir -p ${D}${datadir}/pixmaps
	install -m 0644 ${WORKDIR}/minimo.png ${D}${datadir}/pixmaps/minimo.png
	mkdir -p ${D}${bindir}
	echo "#!/bin/sh" > ${D}${bindir}/Minimo
	cat >>${D}${bindir}/Minimo << EOF
cd ${libdir}/mozilla-minimo
export LD_LIBRARY_PATH=${libdir}/mozilla-minimo
exec ./minimo
EOF
	chmod 755 ${D}${bindir}/Minimo
}
