SUMMARY = "QtopiaCore"
SECTION = "libs"
LICENSE = "GPL"
PRIORITY = "optional"
HOMEPAGE = "http://www.trolltech.com"
DEPENDS = "freetype tslib"

PR = "r0"

SRC_URI = "ftp://ftp.trolltech.com/qt/source/qtopia-core-opensource-src-${PV}.tar.gz \
           file://linux-oe-qmake.conf"

S = "${WORKDIR}/qtopia-core-opensource-src-${PV}"

inherit pkgconfig

# Qmake gets confused by environment variables, as it builds both HOST
# and TARGET objects. The correct compiler settings come from the mkspec
# and are set with the OE_QMAKE_ variables
PARALLEL_MAKE = ""
EXTRA_OEMAKE = " MAKEFLAGS= "

# This stuff could also be done by inheriting qmake, but I didn't want to
# bother with the qmake separation from the Qtopia configure. This separation
# is probably nothing more than a patch on the configure and setting some
# environment variables to use our own qmake/moc/uic, but that's something
# to figure out later.
export OE_QMAKE_CC="${CC}"
export OE_QMAKE_CFLAGS="${CFLAGS}"
export OE_QMAKE_CXX="${CXX}"
export OE_QMAKE_CXXFLAGS="-fno-exceptions ${CXXFLAGS}"
export OE_QMAKE_LDFLAGS="${LDFLAGS}"
export OE_QMAKE_LINK="${CXX}"
export OE_QMAKE_AR="${AR}"
export OE_QMAKE_RANLIB="${RANLIB}"
export OE_QMAKE_STRIP="echo"
export OE_QMAKE_RPATH="-Wl,-rpath-link,"
export OE_QMAKE_INCDIR_QT="${QTDIR}/include"
export OE_QMAKE_LIBDIR_QT="${QTDIR}/lib"
export OE_QMAKE_INCDIR_QTOPIA="${QTOPIADIR}/include"
export OE_QMAKE_LIBDIR_QTOPIA="${QTOPIADIR}/lib"

require qt4_arch.inc
QT_ARCH := "${@qte_arch(d)}"

# FIXME use info.bbclass once it has been commited
QT_ENDIAN = "-little-endian"

# We don't build the examples and demos atm. They're quite big and not used
# frequently, only for testing maybe. Feel free to change and to package
# them separately.
QT_CONFIG_FLAGS = "-release \
    -no-cups -no-accessibility \
    -nomake demos -nomake examples -nomake tools -reduce-relocations \
    -qt-mouse-tslib -qt-gfx-transformed -embedded ${QT_ARCH}"

do_configure() {
    # Hack to honor our compiler flags
    sed -i s/-O2//g ${S}/mkspecs/*/qmake.conf
    sed -i s/-O2//g ${S}/mkspecs/*/*/qmake.conf


    # Install the OE build templates (something which might be done
    # by inheriting qmake)
    for template in linux-oe-g++ linux-uclibc-oe-g++ linux-gnueabi-oe-g++
    do
        install -d ${S}/mkspecs/$template
        install -m 0644 ${WORKDIR}/linux-oe-qmake.conf ${S}/mkspecs/$template/qmake.conf
        ln -sf ../linux-g++/qplatformdefs.h ${S}/mkspecs/$template/qplatformdefs.h
    done

    # The Qmake Makefile generation doesn't like these environment
    # variables, as they mess up the HOST tools builds
    unset CC
    unset CXX
    unset CFLAGS
    unset CXXFLAGS
    unset LDFLAGS

    # For rationale behind the installation locations, see remark above
    echo yes | ./configure -v \
        -prefix ${prefix} \
        -bindir ${bindir} \
        -libdir ${libdir} \
        -docdir ${docdir}/qtopia \
        -headerdir ${includedir} \
        -plugindir ${datadir}/qtopia/plugins \
        -datadir ${datadir} \
        -translationdir ${datadir}/qtopia/translations \
        -sysconfdir ${sysconfdir} \
        -examplesdir ${bindir}/qtopia/examples \
        -demosdir ${bindir}/qtopia/demos \
        -embedded ${QT_ARCH} ${QT_ENDIAN} -fast \
        -xplatform linux-oe-g++ \
        ${QT_CONFIG_FLAGS} \
        -L${STAGING_LIBDIR} -I${STAGING_INCDIR}
}

#
# Fixup some pkgconfig files
# moc_location=/home/zecke/gmit/dela_build/git/openembedded-gmit.zecke/build/oetmp/work/arm-oabi-angstrom-linux/qtopia-core-4.3.0-r2/qtopia-core-opensource-src-4.3.0/bin/moc
# uic_location=/home/zecke/gmit/dela_build/git/openembedded-gmit.zecke/build/oetmp/work/arm-oabi-angstrom-linux/qtopia-core-4.3.0-r2/qtopia-core-opensource-src-4.3.0/bin/uic
#
# Libs: -L${libdir} -lQtNetwork -L/home/zecke/gmit/dela_build/git/openembedded-gmit.zecke/build/oetmp/staging/arm-angstrom-linux/lib -L/home/zecke/gmit/dela_build/git/openembedded-gmit.zecke/build/oetmp/work/arm-oabi-angstrom-linux/qtopia-core-4.3.0-r2/qtopia-core-opensource-src-4.3.0/lib  $(LIBS_EXTRA) -lQtCore -L/home/zecke/gmit/dela_build/git/openembedded-gmit.zecke/build/oetmp/staging/arm-angstrom-linux/lib -L/home/zecke/gmit/dela_build/git/openembedded-gmit.zecke/build/oetmp/work/arm-oabi-angstrom-linux/qtopia-core-4.3.0-r2/qtopia-core-opensource-src-4.3.0/lib -lm -lrt -lpthread -ldl
#
do_compile_append() {
    cd ${S}/lib/pkgconfig
    sed -i s#"-L${S}/lib"##g *.pc
    sed -i s#"moc_location=${S}/bin/moc"#moc_location=${STAGING_BINDIR}/moc4# *.pc
    sed -i s#"uic_location=${S}/bin/uic"#uic_location=${STAGING_BINDIR}/uic4# *.pc
}

do_stage_append() {
    echo "Fixing up Qt"
    cd ${STAGING_LIBDIR}/pkgconfig
    sed -i s#"-L${S}/lib"##g Qt*.pc
    sed -i s#"moc_location=${S}/bin/moc"#moc_location=${STAGING_BINDIR}/moc4# Qt*.pc
    sed -i s#"uic_location=${S}/bin/uic"#uic_location=${STAGING_BINDIR}/uic4# Qt*.pc
}

do_install() {
    oe_runmake install INSTALL_ROOT=${D}

    # These are host binaries, we should only use them in staging
    rm -rf ${D}/${bindir}
    rm -rf ${D}/${datadir}/mkspecs
        
    touch ${D}/${libdir}/fonts/fontdir
}



STAGE_TEMP = "${WORKDIR}/temp-staging"
do_stage() {
    rm -rf ${STAGE_TEMP}
    mkdir -p ${STAGE_TEMP}
    oe_runmake install INSTALL_ROOT=${STAGE_TEMP}

    install -d ${STAGING_INCDIR}/qtopiacore4
    install -d ${STAGING_LIBDIR}/qtopiacore4
    cp -pPRf ${STAGE_TEMP}/$includedir/* ${STAGING_INCDIR}/qtopiacore4/

    for i in ${STAGE_TEMP}/${libdir}/*.la
    do
        oe_libinstall -C ${STAGE_TEMP}/${libdir} -so $(basename $i .la) ${STAGING_LIBDIR}/qtopiacore4
    done

    rm -rf ${STAGE_TEMP}
}


QT_BASE_NAME = "qtopiacore"
QT_BASE_LIB  = "libqtopiacore"
QT_LIBRARY_NAME = "libQt"
require qt_packaging.inc
