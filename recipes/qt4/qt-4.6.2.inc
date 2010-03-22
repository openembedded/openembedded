DEFAULT_PREFERENCE = "-1"

FILESPATHPKG .= ":qt-${PV}"

SRC_URI = "ftp://ftp.trolltech.com/qt/source/qt-everywhere-opensource-src-${PV}.tar.gz \
           file://0001-cross-compile.patch;patch=1 \
           file://0002-fix-resinit-declaration.patch;patch=1 \
           file://0004-no-qmake.patch;patch=1 \
           file://0006-freetype-host-includes.patch;patch=1 \
           file://0008-qt-lib-infix.patch;patch=1 \
           file://0009-support-2bpp.patch;patch=1 \
           file://0010-no-simpledecoration-example.patch;patch=1 \
           file://fix-config-tests.patch;patch=1 \
           file://g++.conf \
           file://linux.conf \
           "

S = "${WORKDIR}/qt-everywhere-opensource-src-${PV}"

do_configure_prepend() {
    for pro in $(find ${S} -name "*.pro") ; do
        sed -i 's:$$QT_BUILD_TREE/bin/lrelease:${OE_QMAKE_LRELEASE}:g' $pro
    done

    sed -i s:SEDME:${S}: ${WORKDIR}/linux.conf
    sed -i \
    -e /QMAKE_MOC\ /d \
    -e /QMAKE_UIC\ /d \
    -e /QMAKE_UIC3\ /d \
    -e /QMAKE_RCC\ /d \
    ${S}/configure
}

do_configure_append() {
    sed -e '/QMAKE_TARGET /d' -e '/TARGET /d' -i ${S}/translations/Makefile
}

QT_GLFLAGS ?= ""
QT_CONFIG_FLAGS += " -no-rpath -qt3support -reduce-relocations -silent ${QT_GLFLAGS}"

do_compile() {
    unset CFLAGS CXXFLAGS
    oe_runmake ${EXTRA_ENV}
}

do_install_append() {
	install -d ${D}${bindir}
	for i in rcc uic moc ; do
		install -m 0755 ${S}/bin/$i ${D}${bindir}/
	done
}

LICENSE = "LGPLv2.1 GPLv3"
SRC_URI += " \
            file://hack-out-pg_config.patch;patch=1"
