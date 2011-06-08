DEFAULT_PREFERENCE = "-1"
LICENSE = "LGPLv2.1 GPLv3"

FILESPATHPKG .= ":qt-${PV}"

SRC_URI = "ftp://ftp.trolltech.com/qt/source/qt-everywhere-opensource-src-${PV}.tar.gz \
           file://blacklist-fraudulent-comodo-certificates-patch.diff \
           file://0001-cross-compile.patch \
           file://0002-fix-resinit-declaration.patch \
           file://0004-no-qmake.patch \
           file://hack-out-pg_config.patch \
           file://0006-freetype-host-includes.patch \
           file://0008-qt-lib-infix.patch \
           file://0009-support-2bpp.patch \
           file://0010-no-simpledecoration-example.patch \
           file://fix-config-tests.patch \
           file://qt-config.patch \
           file://0001-wsegl2-support.patch \
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

	#Append an E to the qtdemo file
	if [ -n "${QT_LIBINFIX}" ] ; then
		mv ${D}${bindir}/qtdemo ${D}${bindir}/qtdemo${QT_LIBINFIX}
	fi
}

SRC_URI[md5sum] = "5c69f16d452b0bb3d44bc3c10556c072"
SRC_URI[sha256sum] = "f4e0ada8d4d516bbb8600a3ee7d9046c9c79e38cd781df9ffc46d8f16acd1768"
