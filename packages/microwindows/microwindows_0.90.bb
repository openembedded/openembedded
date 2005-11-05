DESCRIPTION = "Microwindows Graphical Engine"
SECTION = "x11/wm"
PRIORITY = "optional"
MAINTAINER = "Jordan Crouse <jordan@cosmicpenguin.net>"
DEPENDS = "libpng jpeg"
LICENSE = "GPL"
SRC_URI = "ftp://ftp.microwindows.org/pub/microwindows/microwindows-${PV}.tar.gz"

export EXTRA_OEMAKE = ""

do_compile() {
	if [ "${MACHINE}" = "ipaq" ]; then CONFIG=config.ipaq; fi
	if [ "${MACHINE}" = "ads" ]; then CONFIG=config.ipaq; fi
	if [ "${MACHINE}" = "tuxscreen" ]; then CONFIG=config.ipaq; fi
	if [ "${MACHINE}" = "collie" ]; then CONFIG=config.zaurus; fi
	if [ "${MACHINE}" = "collie" ]; then CONFIG=config.zaurus; fi
	if [ -z "$CONFIG" ]; then CONFIG=config.fb; fi

	cp src/Configs/$CONFIG src/config

	ARCH=`echo ${TARGET_OS}-${TARGET_ARCH} | tr [a-z] [A-Z]`
	cd src
	oe_runmake "ARCH=$ARCH" "TOOLSPREFIX=${TARGET_PREFIX}" "MICROWIN=N" \
	"MICROWINDEMO=N" "NANOWM=N" "SHAREDLIBS=Y" "DEBUG=N" \
	"INCJPEG=${STAGING_INCDIR}" "LIBJPEG=${STAGING_LIBDIR}/libjpeg.so"
}

do_stage() {
	install -m 0644 src/include/nano-X.h ${STAGING_INCDIR}/
	install -m 0644 src/include/mwtypes.h ${STAGING_INCDIR}/
	install -m 0644 src/include/nxcolors.h ${STAGING_INCDIR}/
	install -m 0644 src/include/nxdraw.h ${STAGING_INCDIR}/
	install -m 0755 src/lib/*.so ${STAGING_LIBDIR}/
	install -m 0644 src/lib/*.a ${STAGING_LIBDIR}/
}

do_install() {
	install -d ${D}${bindir} ${D}${libdir}
	install -m 0755 src/lib/*.so ${D}${libdir}
	install -m 0755 src/bin/nano-X ${D}${bindir}/nano-X
	#install -m 0755 src/bin/nxcal ${D}${bindir}/nxcal
}
