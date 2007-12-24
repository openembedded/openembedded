STAGING_QT_DIR = "${STAGING_DIR}/${TARGET_SYS}/qt4"



# FIXME:
# * add missing options
QT_CONFIG_FLAGS += "-no-xinerama -no-tablet -no-xkb -no-opengl"


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

require qt4-x11-free.inc

SRC_URI += " \
           file://0002-fix-resinit-declaration.patch;patch=1 \
           file://0006-freetype-host-includes.patch;patch=1 \
           file://0007-openssl-host-includes.patch;patch=1 "
