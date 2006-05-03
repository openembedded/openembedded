DESCRIPTION = "Qt/X11 Version ${PV}"
SECTION = "x11/libs"
PRIORITY = "optional"
HOMEPAGE = "http://www.trolltech.com"
LICENSE = "GPL QPL"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
DEPENDS = "uicmoc4-native qmake2-native freetype jpeg libx11 xft libxext libxrender libxrandr libxcursor"
PROVIDES = "qt4x11"
PR = "r0"

SRC_URI = "ftp://ftp.trolltech.com/qt/source/qt-x11-opensource-src-${PV}.tar.gz \
           file://cross-compile.patch;patch=1 \
           file://fix-resinit-declaration.patch;patch=1 \
           file://no-tools.patch;patch=1 \
           file://no-qmake.patch;patch=1 \
           file://gcc4_1.patch;patch=1 \
           file://configurable-cpu-extensions.patch;patch=1 \
           file://fix-mkspecs.patch;patch=1"
S = "${WORKDIR}/qt-x11-opensource-src-${PV}"

PARALLEL_MAKE = ""

inherit qmake-base qt4x11 pkgconfig

export QTDIR = "${S}"
STAGING_QT_DIR = "${STAGING_DIR}/${TARGET_SYS}/qt4"
export ARCH = "${TARGET_ARCH}"
export ARCH_i686 = "x86"
EXTRA_OEMAKE = "-e"

# FIXME:
# * add missing options
QT_CONFIG_FLAGS = "-release -shared -qt-zlib -system-libjpeg -no-nas-sound -no-sm -no-libmng -qt-libpng -no-gif -no-xinerama \
                   -no-tablet -no-xkb -no-nis -no-cups -no-opengl \
                   -nosse \
                   -no-sql-ibase -no-sql-mysql -no-sql-odbc -no-sql-psql -no-sql-sqlite -no-sql-sqlite2 \
                   -verbose -stl -no-accessibility"

EXTRA_ENV = 'QMAKE="${STAGING_BINDIR}/qmake2 -after DEFINES+=QT_NO_XIM INCPATH+=${STAGING_INCDIR} \
             INCPATH+=${STAGING_INCDIR}/freetype2 LIBS+=-L${STAGING_LIBDIR}" \
             QMAKESPEC="${QMAKESPEC}" LINK="${CXX} -Wl,-rpath-link,${STAGING_LIBDIR}" \
             AR="${TARGET_PREFIX}ar cqs" \
             MOC="${STAGING_BINDIR}/moc4" UIC="${STAGING_BINDIR}/uic4" MAKE="make -e"'

do_configure() {
	echo "DEFINES -= QT_NO_CAST_TO_ASCII" >>src/qbase.pri
	echo "DEFINES += QT_NO_XIM" >>src/qbase.pri
	unset QMAKESPEC
	#export QMAKESPEC="linux-oe-g++"
	ln -sf ${STAGING_BINDIR}/qmake2 bin/qmake
	#rm -rf ./mkspecs
	#ln -sf ${QMAKE_MKSPEC_PATH} ./mkspecs
	echo yes | ./configure -prefix / -platform ${TARGET_OS}-g++ -crossarch ${ARCH} ${QT_CONFIG_FLAGS} -fast \
		-L${STAGING_LIBDIR} -I${STAGING_INCDIR} -I${STAGING_INCDIR}/freetype2 -I${STAGING_INCDIR}/mysql
}

# FIXME: Might want to compile the cross tools for the -dev packages as well...
do_compile() {
	unset CFLAGS CXXFLAGS
	install -m 0755 ${STAGING_BINDIR}/rcc4 ${S}/bin/rcc
	install -m 0755 ${STAGING_BINDIR}/moc4 ${S}/bin/moc
	install -m 0755 ${STAGING_BINDIR}/uic4 ${S}/bin/uic

	oe_runmake ${EXTRA_ENV}
}

PARTS = "3Support Core Designer DesignerComponents Gui Network Sql Svg Test Xml"

do_stage() {
	oe_runmake install INSTALL_ROOT=/
	install -m 0755 ${STAGING_BINDIR}/rcc4 ${STAGING_QT_DIR}/bin/rcc
	install -m 0755 ${STAGING_BINDIR}/moc4 ${STAGING_QT_DIR}/bin/moc
	install -m 0755 ${STAGING_BINDIR}/uic4 ${STAGING_QT_DIR}/bin/uic

}

# FIXME: Might want to call oe_runmake install INSTALL_ROOT=${D}/${prefix} as well...
# FIXME: Might want to install everything into ${libdir}/qt4/* to match the usual packing...
do_install() {
	install -d ${D}${libdir}
	install -d ${D}${bindir}
	for part in ${PARTS}
	do
		oe_libinstall -so -C lib libQt$part ${D}${libdir}
	done
	oe_libinstall -a -C lib libQtAssistantClient ${STAGING_QT_DIR}
	cp -pPR include/* ${D}${incdir}
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
}

PACKAGES =+ "libqtcore4 libqtgui4 libqtnetwork4 libqtsql4 libqtsvg4 libqttest4 libqtxml4 \
             libqtdesigner4 libqtdesignercomponents4 libqt3support4 \
             qt4-assistant qt4-common qt4-designer qt4-demos qt4-examples qt4-linguist \
             qt4-plugins-accessible qt4-plugins-codecs qt4-plugins-designer qt4-plugins-imageformats qt4-plugins-sqldrivers"

ALLOW_EMPTY = "1"
FILES_${PN} = ""
RDEPENDS_${PN} = "${PACKAGES}"

FILES_libqtcore4               = "${libdir}/libQtCore.so*"
FILES_libqtgui4                = "${libdir}/libQtGui.so*"
FILES_libqtnetwork4            = "${libdir}/libQtNetwork.so*"
FILES_libqtsql4                = "${libdir}/libQtSql.so*"
FILES_libqtsvg4                = "${libdir}/libQtSvg.so*"
FILES_libqttest4               = "${libdir}/libQtTest.so*"
FILES_libqtxml4                = "${libdir}/libQtXml.so*"
FILES_libqtdesigner4           = "${libdir}/libQtDesigner.so*"
FILES_libqtdesignercomponents4 = "${libdir}/libQtDesignerComponents.so*"
FILES_libqt3support4           = "${libdir}/libQt3Support.so*"

FILES_qt4-plugins-accessible   = "${libdir}/plugins/accessible/*.so"
FILES_qt4-plugins-codecs       = "${libdir}/plugins/codecs/*.so"
FILES_qt4-plugins-designer     = "${libdir}/plugins/designer/*.so"
FILES_qt4-plugins-imageformats = "${libdir}/plugins/imageformats/*.so"
FILES_qt4-plugins-sqldrivers   = "${libdir}/plugins/sqldrivers/*.so"

FILES_qt4-assistant            = "${bindir}/*assistant*"
FILES_qt4-designer             = "${bindir}/*designer*"
FILES_qt4-linguist             = "${bindir}/*linguist* ${bindir}/lrelease ${bindir}/lupdate ${bindir}/qm2ts"

FILES_qt4-common               = "${bindir}/qtconfig"
FILES_qt4-examples             = "${bindir}/qt4-examples/*"
FILES_qt4-demos                = "${bindir}/qtdemo ${bindir}/qt4-demos/*"

FILES_${PN}-dev               += "${bindir}/rcc ${bindir}/uic* ${bindir}/moc ${bindir}/qmake ${bindir}/syncqt \
                                  ${bindir}/qt3to4 ${bindir}/findtr"
