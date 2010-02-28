DESCRIPTION = "Native tools for Qt/[X11|Mac|Embedded] version 4.x"
DEPENDS = "zlib-native dbus-native libsm-native"
SECTION = "libs"
HOMEPAGE = "http://www.trolltech.com"
PRIORITY = "optional"
LICENSE = "GPL"

INC_PR = "r6"

inherit native

SRC_URI = "ftp://ftp.trolltech.com/qt/source/qt-everywhere-opensource-src-${PV}.tar.gz \
           file://qt-config.patch;patch=1 \
           file://g++.conf \
           file://linux.conf"
S = "${WORKDIR}/qt-everywhere-opensource-src-${PV}"

EXTRA_OECONF = "-prefix ${prefix} \
                -L ${STAGING_LIBDIR_NATIVE} \
                -I ${STAGING_INCDIR_NATIVE} \
                -qt-libjpeg -qt-gif -system-zlib \
                -no-libjpeg -no-libpng \
                -no-accessibility \
                -no-cups \
                -no-exceptions  \
                -no-nas-sound \
                -no-nis \
                -verbose -release -static \
                -qt3support"

# yank default -e, otherwise we get the following error:
# moc_qbuffer.cpp: No such file or directory
EXTRA_OEMAKE = " "

do_configure() {
   (echo o; echo yes) | ./configure ${EXTRA_OECONF} || die "Configuring qt failed. EXTRA_OECONF was ${EXTRA_OECONF}"
}

TOBUILD = "\
  src/tools/moc \
  src/corelib \
  src/sql \
  src/dbus \
  src/qt3support \
  src/xml \
  src/tools/uic \
  src/tools/rcc \
  src/network \
  src/gui \
  src/tools/uic3 \
  tools/linguist/lrelease \
  tools/linguist/lupdate \
  tools/qdbus \
"

do_compile() {
    for i in ${TOBUILD}; do
        cd ${S}/$i && oe_runmake CC="${CC}" CXX="${CXX}"
    done
}

do_stage() {
    install -d ${STAGING_BINDIR_NATIVE}/
    install -m 0755 bin/qmake ${STAGING_BINDIR_NATIVE}/qmake2
    for i in moc uic uic3 rcc lrelease lupdate qdbuscpp2xml qdbusxml2cpp; do
        install -m 0755 bin/${i} ${STAGING_BINDIR_NATIVE}/${i}4
    done
    
    install -d ${STAGING_DATADIR_NATIVE}/qt4/
    cp -PfR mkspecs ${STAGING_DATADIR_NATIVE}/qt4/
    ln -sf linux-g++ ${STAGING_DATADIR_NATIVE}/qt4/mkspecs/${BUILD_OS}-oe-g++
    cp -f ${WORKDIR}/g++.conf ${WORKDIR}/linux.conf ${STAGING_DATADIR_NATIVE}/qt4/mkspecs/common/

    install -m 0644 tools/porting/src/q3porting.xml ${STAGING_DATADIR_NATIVE}/qt4/
}
