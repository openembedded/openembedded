DEFAULT_PREFERENCE = "-1"

require qt4-x11-free.inc
LICENSE = "LGPLv2.1 GPLv3"
PR = "${INC_PR}.0"

export MOC = "${OE_QMAKE_MOC}"
export QMAKE_MOC = "${OE_QMAKE_MOC}"

SRC_URI = "ftp://ftp.trolltech.com/qt/source/qt-everywhere-opensource-src-${PV}.tar.gz \
           file://0001-cross-compile.patch;patch=1 \
           file://0002-fix-resinit-declaration.patch;patch=1 \
           file://0004-no-qmake.patch;patch=1 \
           file://0006-freetype-host-includes.patch;patch=1 \
           file://0008-qt-lib-infix.patch;patch=1 \
           file://fix-config-tests.patch;patch=1 \
           file://g++.conf \
           file://linux.conf \
"

SRC_URI += "file://hack-out-pg_config.patch;patch=1"

S = "${WORKDIR}/qt-everywhere-opensource-src-${PV}"

QT_CONFIG_FLAGS += " \
 -no-embedded \
 -xrandr \
 -x11"

do_configure_prepend() {
	sed -i \
	-e /QMAKE_MOC\ /d \
	-e /QMAKE_UIC\ /d \
	-e /QMAKE_UIC3\ /d \
	-e /QMAKE_RCC\ /d \
	${S}/configure
}

do_install_append() {
	install -d ${D}${bindir}
	for i in rcc uic moc ; do
		install -m 0755 ${S}/bin/$i ${D}${bindir}/
	done
}

