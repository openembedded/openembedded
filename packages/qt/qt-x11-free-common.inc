DESCRIPTION = "Qt/X11 Version ${PV} is a full fledged cross-platform application framework"
SECTION = "x11/libs"
PRIORITY = "optional"
LICENSE = "GPL QPL"
HOMEPAGE = "http://www.trolltech.com"

S = "${WORKDIR}/qt-x11-free-${PV}"

inherit qmake_base qt3x11

export QTDIR = "${S}"
STAGING_QT_DIR = "${STAGING_DIR}/${HOST_SYS}/qt3"
ARCH_i686 = "x86"
EXTRA_OEMAKE = "-e"

QT_CONFIG_FLAGS = "-release -shared -qt-zlib -no-nas-sound -no-sm -qt-libpng -no-gif -no-xinerama \
                   -no-tablet -no-xkb -no-dlopen-opengl -no-nis -no-cups -thread -plugin-sql-mysql -verbose"

EXTRA_ENV = 'QMAKE="${STAGING_BINDIR_NATIVE}/qmake -after INCPATH+=${STAGING_INCDIR} \
             INCPATH+=${STAGING_INCDIR}/freetype2 LIBS+=-L${STAGING_LIBDIR}" \
             QMAKESPEC="${QMAKESPEC}" LINK="${CXX} -Wl,-rpath-link,${STAGING_LIBDIR}" \
             AR="${TARGET_PREFIX}ar cqs" \
             MOC="${STAGING_BINDIR_NATIVE}/moc3" UIC="${STAGING_BINDIR_NATIVE}/uic3" MAKE="make -e"'

do_configure() {
	echo "yes" | ./configure -prefix ${prefix} ${QT_CONFIG_FLAGS} -fast \
		-L${STAGING_LIBDIR} -I${STAGING_INCDIR} -I${STAGING_INCDIR}/freetype2 -I${STAGING_INCDIR}/mysql
	# force regenerate
	rm -f src/qtmain.pro
	cat Makefile >makefile
	find . -name "Makefile"|xargs rm -f
	(cd src && qmake -spec ${QMAKESPEC} )
	(cd plugins/src && qmake -spec ${QMAKESPEC} )
	(cd tools && qmake -spec ${QMAKESPEC} )
	(cd tools/qvfb && qmake -spec ${QMAKESPEC} )
}

do_compile() {
	unset CFLAGS
	unset CXXFLAGS
	oe_runmake -C src ${EXTRA_ENV}
	oe_runmake -C plugins/src ${EXTRA_ENV}
	oe_runmake -C tools ${EXTRA_ENV}
	oe_runmake -C tools/qvfb ${EXTRA_ENV}
}

do_stage() {
	install -d ${STAGING_QT_DIR}/bin
	ln -sf ${STAGING_BINDIR_NATIVE}/moc3 ${STAGING_QT_DIR}/bin/moc
	ln -sf ${STAGING_BINDIR_NATIVE}/uic3 ${STAGING_QT_DIR}/bin/uic
	ln -sf ${STAGING_BINDIR_NATIVE}/qmake ${STAGING_QT_DIR}/bin/qmake
	install -d ${STAGING_QT_DIR}/lib
	oe_soinstall lib/libqt-mt.so.${PV} ${STAGING_QT_DIR}/lib
	install -d ${STAGING_QT_DIR}/include/private
	for f in include/*.h
	do
		install -m 0644 $f ${STAGING_QT_DIR}/include/
	done
	for f in include/private/*.h
	do
		install -m 0644 $f ${STAGING_QT_DIR}/include/private
	done
	for f in lib/*.prl
	do
		install -m 0644 $f ${STAGING_QT_DIR}/lib
	done
}

do_install() {
	install -d ${D}${libdir}/
	oe_soinstall lib/libqt-mt.so.${PV} ${D}${libdir}/
	install -d ${D}${bindir}/
	install -m 0755 bin/designer bin/assistant tools/qvfb/qvfb bin/qtconfig ${D}${bindir}
	install -d ${D}${prefix}/plugins/
	cp -pPR plugins/imageformats plugins/sqldrivers plugins/designer ${D}${prefix}/plugins/
}

PACKAGES =+ "qt-x11-plugins-imageformats qt-x11-plugins-sqldrivers qt-x11-plugins-designer \
             qt-x11-designer qt-x11-assistant qt-x11-qvfb qt-x11-qtconfig"
FILES_qt-x11-plugins-imageformats = "${prefix}/plugins/imageformats/*.so"
FILES_qt-x11-plugins-sqldrivers = "${prefix}/plugins/sqldrivers/*.so"
FILES_qt-x11-plugins-designer = "${prefix}/plugins/designer/*.so"
FILES_qt-x11-designer = "${bindir}/designer"
FILES_qt-x11-assistant = "${bindir}/assistant"
FILES_qt-x11-qvfb = "${bindir}/qvfb"
FILES_qt-x11-qtconfig = "${bindir}/qtconfig"
FILES_qt-x11-dbg += "${prefix}/plugins/*/.debug ${D}/qt-x11-plugins-debug"
