DESCRIPTION = "A minimal version of the Mozilla web browser"
DEPENDS = "xt gtk+ libidl zip-native unzip-native"
SRC_URI = "cvs://anonymous@cvs-mirror.mozilla.org/cvsroot;module=mozilla \
           file://xptcstubs.patch;patch=1 \
	   file://no-xmb.patch;patch=1 \
	   file://host_ldflags_fix.patch;patch=1 \
	   file://minimo.png file://minimo.desktop \
           file://mozconfig"
S = "${WORKDIR}/mozilla"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
SECTION = "x11"
PRIORITY = "optional"
PV = "0.0cvs${CVSDATE}"
FILES_${PN} += "${libdir}/mozilla-minimo"
PR = "r7"
LICENSE = "MPL/LGPL/GPL"

export MINIMO=1
export CROSS_COMPILE=1
export CONFIGURE_ARGS="--target=${TARGET_SYS} --host=${BUILD_SYS} --build=${BUILD_SYS}  --enable-application=suite"
export CXX=${CC}
export HOST_LIBIDL_CONFIG="${STAGING_BINDIR}/libIDL-config-2"
export HOST_PKG_CONFIG_PATH="${STAGING_DIR}/${BUILD_SYS}/share/pkgconfig"
export MOZ_OBJDIR="${WORKDIR}/build-${TARGET_SYS}"
export MOZCONFIG="${WORKDIR}/mozconfig"
export MOZ_CO_PROJECT="suite"
export HOST_CC=${BUILD_CC}
export HOST_CXX=${BUILD_CXX}
export HOST_CFLAGS=${BUILD_CFLAGS}
export HOST_CXXFLAGS=${BUILD_CXXFLAGS}
export HOST_LDFLAGS=${BUILD_LDFLAGS}
export HOST_RANLIB=${BUILD_RANLIB}
export HOST_AR=${BUILD_AR}

SELECTED_OPTIMIZATION = "-Os -fsigned-char -fno-strict-aliasing"

do_fetch () {
	mkdir -p ${WORKDIR}
	cd ${WORKDIR}
	if [ ! -f ${DL_DIR}/mozilla_cvs-mirror.mozilla.org__${CVSDATE}.tar.gz ]; then
		cvs $CVSCOOPTS -d :pserver:anonymous@cvs-mirror.mozilla.org/cvsroot co mozilla/client.mk
		cd mozilla
		make -f client.mk checkout
		cd ..
		tar czf ${DL_DIR}/mozilla_cvs-mirror.mozilla.org__${CVSDATE}.tar.gz mozilla
	fi
}

do_compile () {
	make -f client.mk build_all
	cd $MOZ_OBJDIR/embedding/minimo
	make
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
