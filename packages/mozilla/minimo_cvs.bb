DESCRIPTION = "A minimal version of the Mozilla web browser"
SRC_URI = "cvs://anonymous@cvs-mirror.mozilla.org/cvsroot;module=mozilla \
           file://xptcstubs.patch;patch=1 \
	   file://no-xmb.patch;patch=1 \
	   file://host_ldflags_fix.patch;patch=1 \
	   file://minimo.png file://minimo.desktop"
S = "${WORKDIR}/mozilla"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
SECTION = "x11"
PRIORITY = "optional"
PV = "0.0cvs${CVSDATE}"
FILES_${PN} += "${libdir}/mozilla-minimo"
PR = "r7"
LICENSE = "MPL/LGPL/GPL"

inherit mozilla

EXTRA_OECONF += "--enable-application=suite"

export MINIMO=1
export MOZ_OBJDIR="${WORKDIR}/build-${TARGET_SYS}"
export MOZ_CO_PROJECT="suite"

do_fetch () {
	mkdir -p ${WORKDIR}
	cd ${WORKDIR}
	if [ ! -f ${DL_DIR}/mozilla_cvs-mirror.mozilla.org__${CVSDATE}.tar.gz ]; then
		cvs $CVSCOOPTS -d :pserver:anonymous@cvs-mirror.mozilla.org/cvsroot co mozilla/client.mk
		cd mozilla
		oe_runmake -f client.mk checkout
		cd ..
		tar czf ${DL_DIR}/mozilla_cvs-mirror.mozilla.org__${CVSDATE}.tar.gz mozilla
	fi
}

do_compile () {
	mozilla_do_compile
	cd $MOZ_OBJDIR/embedding/minimo
	oe_runmake
}

mozdir="${D}${libdir}/mozilla-minimo"

do_install () {
	cd ${S}/embedding/minimo/
	sh ./package.sh
	cd ${S}
	mkdir -p ${mozdir}
	cp -rL $MOZ_OBJDIR/dist/Embed/* ${mozdir}/
	rm -f ${mozdir}/TestGtkEmbed
	mkdir -p ${D}/${datadir}/applications
	install -m 0644 ${WORKDIR}/minimo.desktop ${D}/${datadir}/applications/minimo.desktop
	mkdir -p ${D}/${datadir}/pixmaps
	install -m 0644 ${WORKDIR}/minimo.png ${D}/${datadir}/pixmaps/minimo.png
	mkdir -p ${D}/${bindir}
	echo "#!/bin/sh" > ${D}/${bindir}/minimo
	cat >>${D}/${bindir}/minimo << EOF
cd ${libdir}/mozilla-minimo
export LD_LIBRARY_PATH=${libdir}/mozilla-minimo
exec ./Minimo http://www.mozilla.org/projects/minimo/home.html
EOF
	chmod 755 ${D}/${bindir}/minimo
}
