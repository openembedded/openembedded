DESCRIPTION = "Qt/X11 Version ${PV}"
SECTION = "x11/libs"
PRIORITY = "optional"
HOMEPAGE = "http://www.trolltech.com"
LICENSE = "GPL QPL"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
DEPENDS = "uicmoc4-native freetype jpeg x11 xft xext libxrender libxrandr libxcursor mysql"
PROVIDES = "qt4x11"
# FIXME: Make it use 'our' qmake
# DEPENDS += "qmake-native-2.00a"
PR = "r1"

SRC_URI = "ftp://ftp.trolltech.com/qt/source/qt-x11-opensource-src-${PV}.tar.gz \
           file://cross-compile.patch;patch=1 \
           file://fix-resinit-declaration.patch;patch=1 \
           file://no-tools.patch;patch=1"
S = "${WORKDIR}/qt-x11-opensource-src-${PV}"

# Not the prime time of Qt4 yet ...
# TODO: make it not look in /usr and /usr/include for its tests!
DEFAULT_PREFERENCE = "-1"
BROKEN             = "1"

PARALLEL_MAKE = ""

inherit qmake-base qt4x11 pkgconfig

export QTDIR = "${S}"
STAGING_QT_DIR = "${STAGING_DIR}/${TARGET_SYS}/qt4"
export ARCH = "${TARGET_ARCH}"
export ARCH_i686 = "x86"
EXTRA_OEMAKE = "-e"

QT_CONFIG_FLAGS = "-release -shared -qt-zlib -system-libjpeg -no-nas-sound -no-sm -qt-libpng -no-gif -no-xinerama \
                   -no-tablet -no-xkb -no-nis -no-cups -no-opengl -plugin-sql-mysql -verbose -stl"

# EXTRA_ENV = 'QMAKE="${STAGING_BINDIR}/qmake -after INCPATH+=${STAGING_INCDIR} \

EXTRA_ENV = 'QMAKE="${S}/bin/qmake -after DEFINES+=QT_NO_XIM INCPATH+=${STAGING_INCDIR} \
             INCPATH+=${STAGING_INCDIR}/freetype2 LIBS+=-L${STAGING_LIBDIR}" \
             QMAKESPEC="${QMAKESPEC}" LINK="${CXX} -Wl,-rpath-link,${STAGING_LIBDIR}" \
             AR="${TARGET_PREFIX}ar cqs" \
             MOC="${STAGING_BINDIR}/moc4" UIC="${STAGING_BINDIR}/uic4" MAKE="make -e"'

do_configure() {
	echo "DEFINES -= QT_NO_CAST_TO_ASCII" >>src/qbase.pri
	echo "DEFINES += QT_NO_XIM" >>src/qbase.pri
	unset QMAKESPEC
	echo yes | ./configure -prefix ${prefix} -crossarch ${ARCH} ${QT_CONFIG_FLAGS} -fast \
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

PARTS = "3Support Core Designer DesignerComponents Gui Network Sql Xml"

do_stage() {
	install -d ${STAGING_QT_DIR}
	for part in ${PARTS}
	do
		oe_libinstall -so -C lib libQt$part ${STAGING_QT_DIR}
	done
	oe_libinstall -a -C lib libQtAssistantClient ${STAGING_QT_DIR}
	cp -pPR include/* ${STAGING_INCDIR}/
}

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
}

PACKAGES =+ "libqtcore4 libqtxml4 libqtgui4 libqtnetwork4 libqtsql4 libqtdesigner4 libqtdesignercomponents4 \
             qt4-assistant qt4-designer qt4-examples qt4-linguist \
             qt4-plugins-accessible qt4-plugins-codecs qt4-plugins-designer qt4-plugins-imageformats qt4-plugins-sqldrivers"

FILES_libqtcore4               = "${libdir}/libQtCore.so*"
FILES_libqtgui4                = "${libdir}/libQtGui.so*"
FILES_libqtnetwork4            = "${libdir}/libQtNetwork.so*"
FILES_libqtxml4                = "${libdir}/libQtXml.so*"
FILES_libqtsql4                = "${libdir}/libQtSql.so*"
FILES_libqtdesigner4           = "${libdir}/libQtDesigner.so*"
FILES_libqtdesignercomponents4 = "${libdir}/libQtDesignerComponents.so*"

FILES_qt4-plugins-accessible   = "${libdir}/plugins/accessible/*.so"
FILES_qt4-plugins-codecs       = "${libdir}/plugins/codecs/*.so"
FILES_qt4-plugins-designer     = "${libdir}/plugins/designer/*.so"
FILES_qt4-plugins-imageformats = "${libdir}/plugins/imageformats/*.so"
FILES_qt4-plugins-sqldrivers   = "${libdir}/plugins/sqldrivers/*.so"

FILES_qt4-assistant            = "${bindir}/*assistant*"
FILES_qt4-designer             = "${bindir}/*designer*"
FILES_qt4-linguist             = "${bindir}/*linguist* ${bindir}/lrelease ${bindir}/lupdate ${bindir}/qm2ts"

FILES_qt4-examples             = "${bindir}/qt4-examples/*"
