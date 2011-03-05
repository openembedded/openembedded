DEFAULT_PREFERENCE = "-1"
LICENSE = "LGPLv2.1 GPLv3"

FILESPATHPKG =. "qt-${PV}:"

SRC_URI = "\
	ftp://ftp.trolltech.com/qt/source/qt-everywhere-opensource-src-${PV}.tar.gz \
	file://0004-no-qmake.patch \
    file://hack-out-pg2-4.7.0.patch \
	file://0006-freetype-host-includes.patch \
	file://0001-Added-Openembedded-crossarch-option.patch \
	file://0010-phonon-gstreamer-rgb-endianess.patch \
	file://g++.conf \
	file://linux.conf \
           "
# Set necessary variables in the profile
SRC_URI += "file://qte.sh"

S = "${WORKDIR}/qt-everywhere-opensource-src-${PV}"

FILES_${QT_BASE_NAME}-tools                += "${bindir}/qml"

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
QT_CONFIG_FLAGS += " -javascript-jit -script -scripttools -declarative -xmlpatterns -no-rpath -qt3support -reduce-relocations -silent ${QT_GLFLAGS}"

do_compile() {
    # Fixup missing wsegl header in some SGX SDKs
    if ! [ -e ${STAGING_INCDIR}/wsegl.h ] ; then
        cp src/3rdparty/powervr/wsegl.h src/plugins/gfxdrivers/powervr/QWSWSEGL/
    fi

    unset CFLAGS CXXFLAGS
    install -m 0755 ${STAGING_BINDIR_NATIVE}/rcc4 ${S}/bin/rcc
    install -m 0755 ${STAGING_BINDIR_NATIVE}/moc4 ${S}/bin/moc
    install -m 0755 ${STAGING_BINDIR_NATIVE}/uic4 ${S}/bin/uic
    install -m 0755 ${STAGING_BINDIR_NATIVE}/lrelease4 ${S}/bin/lrelease

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

SRC_URI[md5sum] = "66b992f5c21145df08c99d21847f4fdb"
SRC_URI[sha256sum] = "d4783b524b90bcd270ccf6e7a30d5fb51696c47eb5de49ebc2d553cd3eb49336"
