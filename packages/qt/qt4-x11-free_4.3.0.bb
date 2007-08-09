SECTION = "x11/libs"
PRIORITY = "optional"
HOMEPAGE = "http://www.trolltech.com"
LICENSE = "GPL QPL"
DEPENDS = "pkgconfig-native uicmoc4-native qmake2-native freetype jpeg virtual/libx11 xft libxext libxrender libxrandr libxcursor dbus openssl"
RDEPENDS_${PN} = "${NONDEV_PACKAGES}"
PROVIDES = "qt4x11"

PR = "r5"

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

inherit qmake-base qt4x11

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
	install -m 0755 ${STAGING_BINDIR_NATIVE}/rcc4 ${STAGING_QT_DIR}/bin/rcc
	install -m 0755 ${STAGING_BINDIR_NATIVE}/moc4 ${STAGING_QT_DIR}/bin/moc
	install -m 0755 ${STAGING_BINDIR_NATIVE}/uic4 ${STAGING_QT_DIR}/bin/uic
	sed -i -e 's,^QMAKE_RPATHDIR.*,QMAKE_RPATHDIR=${STAGING_QT_DIR}/lib,g'  ${STAGING_QT_DIR}/mkspecs/qconfig.pri
	for pc in ${STAGING_QT_DIR}/lib/pkgconfig/Qt{AssistantClient,DBus,Test,UiTools}.pc ; do
		sed -i -e 's,${S}/lib,${STAGING_QT_DIR}/lib,g' $pc
	done
        for pc in ${STAGING_QT_DIR}/lib/pkgconfig/*.pc ; do
                install -m 0644 $pc ${PKG_CONFIG_PATH}/
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

NONDEV_PACKAGES = "libqtcore4 libqtgui4 libqtnetwork4  \
             libqtsql4 libqtsvg4 libqttest4 \
             libqtxml4 \
             libqtdesigner4 libqtdesignercomponents4 \
             libqt3support4 \
             libqtassistantclient4 libqtscript4 \
             libqtdbus4 \
             qt4-assistant qt4-common qt4-designer qt4-demos qt4-examples qt4-linguist \
             qt4-pixeltool qt4-dbus \
             qt4-plugins-accessible qt4-plugins-codecs qt4-plugins-designer qt4-plugins-imageformats qt4-plugins-sqldrivers \
             qt4-plugins-inputmethods qt4-plugins-iconengines"

PACKAGES += "libqtcore4-dev libqtgui4-dev libqtnetwork4-dev libqtsql4-dev libqtsvg4-dev libqttest4-dev \
             libqtxml4-dev libqtdesigner4-dev libqtdesignercomponents4-dev libqt3support4-dev \
             libqtassistantclient4-dev libqtscript4-dev libqtdbus4-dev \
	     ${NONDEV_PACKAGES}"

ALLOW_EMPTY = "1"
FILES_${PN} = ""

FILES_libqtcore4                   = "${libdir}/libQtCore.so.*"
FILES_libqtcore4-dev               = "${libdir}/libQtCore.so"
FILES_libqtgui4                    = "${libdir}/libQtGui.so.*"
FILES_libqtgui4-dev                = "${libdir}/libQtGui.so"
FILES_libqtnetwork4                = "${libdir}/libQtNetwork.so.*"
FILES_libqtnetwork4-dev            = "${libdir}/libQtNetwork.so"
FILES_libqtsql4                    = "${libdir}/libQtSql.so.*"
FILES_libqtsql4-dev                = "${libdir}/libQtSql.so"
FILES_libqtsvg4                    = "${libdir}/libQtSvg.so.*"
FILES_libqtsvg4-dev                = "${libdir}/libQtSvg.so"
FILES_libqttest4                   = "${libdir}/libQtTest.so.*"
FILES_libqttest4-dev               = "${libdir}/libQtTest.so"
FILES_libqtxml4                    = "${libdir}/libQtXml.so.*"
FILES_libqtxml4-dev                = "${libdir}/libQtXml.so"
FILES_libqtdesigner4               = "${libdir}/libQtDesigner.so.*"
FILES_libqtdesigner4-dev           = "${libdir}/libQtDesigner.so"
FILES_libqtdesignercomponents4     = "${libdir}/libQtDesignerComponents.so.*"
FILES_libqtdesignercomponents4-dev = "${libdir}/libQtDesignerComponents.so"
FILES_libqt3support4               = "${libdir}/libQt3Support.so.*"
FILES_libqt3support4-dev           = "${libdir}/libQt3Support.so"
FILES_libqtassistantclient4        = "${libdir}/libQtAssistantClient.so.*"
FILES_libqtassistantclient4-dev    = "${libdir}/libQtAssistantClient.so"
FILES_libqtscript4                 = "${libdir}/libQtScript.so.*"
FILES_libqtscript4-dev             = "${libdir}/libQtScript.so"
FILES_libqtdbus4                   = "${libdir}/libQtDBus.so.*"
FILES_libqtdbus4-dev               = "${libdir}/libQtDBus.so"

FILES_qt4-plugins-accessible   = "${libdir}/plugins/accessible/*.so"
FILES_qt4-plugins-codecs       = "${libdir}/plugins/codecs/*.so"
FILES_qt4-plugins-designer     = "${libdir}/plugins/designer/*.so"
FILES_qt4-plugins-imageformats = "${libdir}/plugins/imageformats/*.so"
FILES_qt4-plugins-sqldrivers   = "${libdir}/plugins/sqldrivers/*.so"
FILES_qt4-plugins-inputmethods = "${libdir}/plugins/inputmethods/*.so"
FILES_qt4-plugins-iconengines  = "${libdir}/plugins/iconengines/*.so"

FILES_qt4-assistant            = "${bindir}/*assistant*"
FILES_qt4-designer             = "${bindir}/*designer*"
FILES_qt4-linguist             = "${bindir}/*linguist* ${bindir}/lrelease ${bindir}/lupdate ${bindir}/qm2ts"
FILES_qt4-pixeltool            = "${bindir}/pixeltool"
FILES_qt4-dbus                 = "${bindir}/qdbus ${bindir}/qdbusxml2cpp ${bindir}/qdbuscpp2xml ${bindir}/qdbusviewer"

FILES_qt4-common               = "${bindir}/qtconfig"
FILES_qt4-examples             = "${bindir}/qt4-examples/*"
FILES_qt4-demos                = "${bindir}/qtdemo ${bindir}/qt4-demos/*"

FILES_${PN}-dev               += "${bindir}/rcc ${bindir}/uic* ${bindir}/moc ${bindir}/qmake ${bindir}/syncqt \
                                  ${bindir}/qt3to4 ${bindir}/findtr"
FILES_${PN}-dbg                += "${bindir}/*/.debug ${plugindir}/.debug"
