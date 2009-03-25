DESCRIPTION = "Native tools for Qt/[X11|Mac|Embedded] version 4.x"
DEPENDS = "zlib-native"
SECTION = "libs"
HOMEPAGE = "http://www.trolltech.com"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r0"

inherit native

SRC_URI = "ftp://ftp.trolltech.com/qt/source/qt-embedded-linux-opensource-src-${PV}.tar.bz2 \
           file://qt-config.patch;patch=1" 
S = "${WORKDIR}/qt-embedded-linux-opensource-src-${PV}"

EXTRA_OECONF = "-prefix ${prefix} \
                -qt-libjpeg -qt-gif -system-zlib \
                -no-nis -no-cups -no-exceptions  \
                -no-accessibility -no-libjpeg    \
                -no-nas-sound -no-sm             \
                -no-xshape    -no-xinerama       \
                -no-xcursor   -no-xrandr         \
                -no-xrender   -no-fontconfig     \
                -no-tablet    -no-xkb            \
                -no-libpng                       \
                -verbose -release  -fast -static \
                -qt3support "
# yank default -e
EXTRA_OEMAKE = " "

do_configure() {
    # Make sure we regenerate all Makefiles
    find ${S} -name "Makefile" | xargs rm

    sed -i 's:^QT += xml qt3support$:QT += xml qt3support network:' "${S}"/src/tools/uic3/uic3.pro
    echo yes | ./configure ${EXTRA_OECONF} || die "Configuring qt failed. EXTRA_OECONF was ${EXTRA_OECONF}"
}

TOBUILD = "\
  src/tools/moc \
  src/corelib \
  src/sql \
  src/qt3support \
  src/xml \
  src/tools/uic \
  src/tools/rcc \
  src/network \
  src/gui \
  src/tools/uic3 \
  tools/linguist/lrelease \
  tools/linguist/lupdate \
"

do_compile() {
    for i in ${TOBUILD}; do
        cd ${S}/$i && oe_runmake CC="${CC}" CXX="${CXX}"
    done
}

do_stage() {
	install -d ${STAGING_BINDIR}/
    install -m 0755 bin/qmake ${STAGING_BINDIR}/qmake2
    ln -sf qmake2 ${STAGING_BINDIR}/qmake-qt4
    for i in moc uic uic3 rcc lrelease lupdate; do
        install -m 0755 bin/${i} ${STAGING_BINDIR}/${i}4
    done
    install -d ${STAGING_DATADIR_NATIVE}/qt4/
    cp -PfR mkspecs ${STAGING_DATADIR_NATIVE}/qt4/
    install -m 0644 tools/porting/src/q3porting.xml ${STAGING_DATADIR_NATIVE}/qt4/
}
