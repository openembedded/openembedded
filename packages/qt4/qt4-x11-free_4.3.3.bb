DESCRIPTION = "Qt is a versatile cross-platform application framework -- this is the X11 version."
SECTION = "x11/libs"
PRIORITY = "optional"
HOMEPAGE = "http://www.trolltech.com"
LICENSE = "GPL QPL"
DEPENDS = "pkgconfig-native uicmoc4-native qmake2-native freetype jpeg virtual/libx11 \
           xft libxext libxrender libxrandr libxcursor dbus openssl"
PROVIDES = "qt4x11"
PR = "r6"

SRC_URI = "ftp://ftp.trolltech.com/qt/source/qt-x11-opensource-src-${PV}.tar.gz \
           file://0001-cross-compile.patch;patch=1 \
           file://0002-fix-resinit-declaration.patch;patch=1 \
           file://0003-no-tools.patch;patch=1 \
           file://0004-no-qmake.patch;patch=1 \
           file://0005-fix-mkspecs.patch;patch=1 \
           file://0006-freetype-host-includes.patch;patch=1 \
           file://0007-openssl-host-includes.patch;patch=1"
S = "${WORKDIR}/qt-x11-opensource-src-${PV}"

PARALLEL_MAKE = ""

inherit qmake_base qt4x11

export QTDIR = "${S}"
STAGING_QT_DIR = "${STAGING_DIR}/${TARGET_SYS}/qt4"
EXTRA_OEMAKE = "-e"

require qt4_arch.inc

QT_ARCH := "${@qt_arch(d)}"

# FIXME:
# * add missing options
QT_CONFIG_FLAGS = "-release -shared -qt-zlib -system-libjpeg -no-nas-sound -no-sm -no-libmng -qt-libpng -no-gif -no-xinerama \
                   -no-tablet -no-xkb -no-nis -no-cups -no-opengl \
                   -no-sse -no-sse2 -no-mmx -no-3dnow \
                   -no-sql-ibase -no-sql-mysql -no-sql-odbc -no-sql-psql -no-sql-sqlite -no-sql-sqlite2 \
                   -qdbus \
                   -verbose -stl -no-accessibility \
                   -pch -no-glib"

EXTRA_ENV = 'QMAKE="${STAGING_BINDIR_NATIVE}/qmake2 -after DEFINES+=QT_NO_XIM INCPATH+=${STAGING_INCDIR} \
             INCPATH+=${STAGING_INCDIR}/freetype2 LIBS+=-L${STAGING_LIBDIR}" \
             QMAKESPEC="${QMAKESPEC}" LINK="${CXX} -Wl,-rpath-link,${STAGING_LIBDIR}" \
             AR="${TARGET_PREFIX}ar cqs" \
             MOC="${STAGING_BINDIR_NATIVE}/moc4" UIC="${STAGING_BINDIR_NATIVE}/uic4" MAKE="make -e"'

do_configure() {
	echo "DEFINES -= QT_NO_CAST_TO_ASCII" >>src/qbase.pri
	echo "DEFINES += QT_NO_XIM" >>src/qbase.pri
	unset QMAKESPEC
	ln -sf ${STAGING_BINDIR_NATIVE}/qmake2 bin/qmake
	ln -s linux-g++ mkspecs/${TARGET_OS}-oe-g++
	#export QMAKESPEC="linux-oe-g++"
	#rm -rf ./mkspecs
	#ln -sf ${QMAKE_MKSPEC_PATH} ./mkspecs
	echo yes | ./configure -prefix / -platform ${TARGET_OS}-oe-g++ -crossarch ${QT_ARCH} ${QT_CONFIG_FLAGS} -fast \
		-L${STAGING_LIBDIR} -I${STAGING_INCDIR} -I${STAGING_INCDIR}/freetype2 -I${STAGING_INCDIR}/mysql
}

# FIXME: Might want to compile the cross tools for the -dev packages as well...
do_compile() {
	unset CFLAGS CXXFLAGS
	install -m 0755 ${STAGING_BINDIR_NATIVE}/rcc4 ${S}/bin/rcc
	install -m 0755 ${STAGING_BINDIR_NATIVE}/moc4 ${S}/bin/moc
	install -m 0755 ${STAGING_BINDIR_NATIVE}/uic4 ${S}/bin/uic

	oe_runmake ${EXTRA_ENV}
}

PARTS = "3Support AssistantClient Core DBus Designer DesignerComponents Gui Network Script Sql Svg Test Xml"

do_stage() {
	oe_runmake install INSTALL_ROOT=/
	install -d ${STAGING_QT_DIR}
	install -m 0755 ${STAGING_BINDIR_NATIVE}/rcc4 ${STAGING_QT_DIR}/bin/rcc
	install -m 0755 ${STAGING_BINDIR_NATIVE}/moc4 ${STAGING_QT_DIR}/bin/moc
	install -m 0755 ${STAGING_BINDIR_NATIVE}/uic4 ${STAGING_QT_DIR}/bin/uic
	sed -i -e 's,^QMAKE_RPATHDIR.*,QMAKE_RPATHDIR=${STAGING_QT_DIR}/lib,g' ${STAGING_QT_DIR}/mkspecs/qconfig.pri
	for pcc in AssistantClient DBus Test UiTools ; do
		sed -i -e 's,${S}/lib,${STAGING_QT_DIR}/lib,g' ${STAGING_QT_DIR}/lib/pkgconfig/Qt${pcc}.pc
	done
	install -d ${PKG_CONFIG_DIR}/
        for pc in ${STAGING_QT_DIR}/lib/pkgconfig/*.pc ; do
		sed -i -e 's,$(OE_QMAKE_LIBS_X11),-lX11 -lXext,g' $pc
                install -m 0644 $pc ${PKG_CONFIG_DIR}/
        done
}

# FIXME: Might want to call oe_runmake install INSTALL_ROOT=${D}/${prefix} as well...
# FIXME: Might want to install everything into ${libdir}/qt4/* to match the usual packing...
do_install() {
	install -d ${D}${libdir}
	install -d ${D}${bindir}
	install -d ${D}${includedir}
	for part in ${PARTS}
	do
		oe_libinstall -so -C lib libQt$part ${D}${libdir}
	done
	oe_libinstall -a -C lib libQtUiTools ${D}${libdir}
	cp -pPR include/* ${D}${includedir}
	cp -pPR plugins ${D}${libdir}
	cp -pPR bin/* ${D}${bindir}

	install -d ${D}${bindir}/qt4-examples
	for binary in `find examples -perm 0755 -type f`
	do
		install -m 0755 $binary ${D}${bindir}/qt4-examples/
	done
	install -d ${D}${bindir}/qt4-demos
	for binary in `find demos -perm 0755 -type f`
	do
		install -m 0755 $binary ${D}${bindir}/qt4-demos/
	done
	rm ${D}${bindir}/rcc ${D}${bindir}/uic ${D}${bindir}/moc
}

QT_BASE_NAME = "qt4"
QT_BASE_LIB  = "libqt"
QT_LIBRARY_NAME = "libQt"
require qt_packaging.inc
