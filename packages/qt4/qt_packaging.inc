NONDEV_PACKAGES = "${QT_BASE_LIB}core4 ${QT_BASE_LIB}gui4 ${QT_BASE_LIB}network4  \
             ${QT_BASE_LIB}sql4 ${QT_BASE_LIB}svg4 ${QT_BASE_LIB}test4 ${QT_BASE_LIB}xml4 \
             ${QT_BASE_LIB}designer4 ${QT_BASE_LIB}designercomponents4 \
             ${QT_BASE_LIB}3support4 ${QT_BASE_LIB}assistantclient4 ${QT_BASE_LIB}script4 \
             ${QT_BASE_LIB}dbus4 ${QT_BASE_LIB}opengl4 \
             ${QT_BASE_NAME}-assistant ${QT_BASE_NAME}-common \
             ${QT_BASE_NAME}-designer \
             ${QT_BASE_NAME}-demos ${QT_BASE_NAME}-examples \
             ${QT_BASE_NAME}-linguist \
             ${QT_BASE_NAME}-pixeltool ${QT_BASE_NAME}-dbus \
             ${QT_BASE_NAME}-plugins-accessible \
             ${QT_BASE_NAME}-plugins-codecs \
             ${QT_BASE_NAME}-plugins-designer \
             ${QT_BASE_NAME}-plugins-imageformats \
             ${QT_BASE_NAME}-plugins-sqldrivers \
             ${QT_BASE_NAME}-plugins-inputmethods \
             ${QT_BASE_NAME}-plugins-iconengines \
             ${QT_BASE_NAME}-fonts "

DEV_PACKAGES += "${QT_BASE_LIB}core4-dev \
             ${QT_BASE_LIB}gui4-dev \
             ${QT_BASE_LIB}network4-dev \
             ${QT_BASE_LIB}sql4-dev \
             ${QT_BASE_LIB}svg4-dev \
             ${QT_BASE_LIB}test4-dev \
             ${QT_BASE_LIB}xml4-dev \
             ${QT_BASE_LIB}designer4-dev \
             ${QT_BASE_LIB}designercomponents4-dev \
             ${QT_BASE_LIB}3support4-dev \
             ${QT_BASE_LIB}assistantclient4-dev \
             ${QT_BASE_LIB}script4-dev \
             ${QT_BASE_LIB}dbus4-dev \
             ${QT_BASE_LIB}opengl4-dev \
             ${QT_BASE_LIB}uitools4-dev \
             ${QT_BASE_LIB}-documentation"

DBG_PACKAGES += "${QT_BASE_LIB}core4-dbg \
             ${QT_BASE_LIB}gui4-dbg \
             ${QT_BASE_LIB}network4-dbg \
             ${QT_BASE_LIB}sql4-dbg \
             ${QT_BASE_LIB}svg4-dbg \
             ${QT_BASE_LIB}test4-dbg \
             ${QT_BASE_LIB}xml4-dbg \
             ${QT_BASE_LIB}designer4-dbg \
             ${QT_BASE_LIB}designercomponents4-dbg \
             ${QT_BASE_LIB}3support4-dbg \
             ${QT_BASE_LIB}assistantclient4-dbg \
             ${QT_BASE_LIB}script4-dbg \
             ${QT_BASE_LIB}dbus4-dbg \
             ${QT_BASE_LIB}opengl4-dbg "


PACKAGES += "${DEV_PACKAGES} ${NONDEV_PACKAGES} ${DBG_PACKAGES}"

ALLOW_EMPTY_${PN} = "1"
FILES_${PN}     = ""
FILES_${PN}-dev = " ${includedir}/${QT_DIR_NAME}/Qt/*"
FILES_${PN}-dbg = "${bindir}/*/.debug ${libdir}/${QT_DIR_NAME}/plugins/*/.debug/*.so"
RDEPENDS_${PN} = "${NONDEV_PACKAGES}"
RDEPENDS_${PN}-dev = "${DEV_PACKAGES}"
RDEPENDS_${PN}-dbg = "${DBG_PACKAGES}"


FILES_${QT_BASE_LIB}core4                   = "${libdir}/lib${QT_LIBRARY_NAME}Core.so.*"
FILES_${QT_BASE_LIB}core4-dev               = "${libdir}/lib${QT_LIBRARY_NAME}Core.so ${includedir}/${QT_DIR_NAME}/QtCore* ${libdir}/pkgconfig/${QT_LIBRARY_NAME}Core.pc"
FILES_${QT_BASE_LIB}core4-dbg               = "${libdir}/.debug/lib${QT_LIBRARY_NAME}Core*"
FILES_${QT_BASE_LIB}gui4                    = "${libdir}/lib${QT_LIBRARY_NAME}Gui.so.*"
FILES_${QT_BASE_LIB}gui4-dev                = "${libdir}/lib${QT_LIBRARY_NAME}Gui.so ${includedir}/${QT_DIR_NAME}/QtGui* ${libdir}/pkgconfig/${QT_LIBRARY_NAME}Gui.pc"
FILES_${QT_BASE_LIB}gui4-dbg                = "${libdir}/.debug/lib${QT_LIBRARY_NAME}Gui*"
FILES_${QT_BASE_LIB}network4                = "${libdir}/lib${QT_LIBRARY_NAME}Network.so.*"
FILES_${QT_BASE_LIB}network4-dev            = "${libdir}/lib${QT_LIBRARY_NAME}Network.so ${includedir}/${QT_DIR_NAME}/QtNetwork* ${libdir}/pkgconfig/${QT_LIBRARY_NAME}Network.pc"
FILES_${QT_BASE_LIB}network4-dbg            = "${libdir}/.debug/lib${QT_LIBRARY_NAME}Network*"
FILES_${QT_BASE_LIB}sql4                    = "${libdir}/lib${QT_LIBRARY_NAME}Sql.so.*"
FILES_${QT_BASE_LIB}sql4-dev                = "${libdir}/lib${QT_LIBRARY_NAME}Sql.so ${includedir}/${QT_DIR_NAME}/QtSql* ${libdir}/pkgconfig/${QT_LIBRARY_NAME}Sql.pc"
FILES_${QT_BASE_LIB}sql4-dbg                = "${libdir}/.debug/lib${QT_LIBRARY_NAME}Sql*"
FILES_${QT_BASE_LIB}svg4                    = "${libdir}/lib${QT_LIBRARY_NAME}Svg.so.*"
FILES_${QT_BASE_LIB}svg4-dev                = "${libdir}/lib${QT_LIBRARY_NAME}Svg.so ${includedir}/${QT_DIR_NAME}/QtSvg* ${libdir}/pkgconfig/${QT_LIBRARY_NAME}Svg.pc"
FILES_${QT_BASE_LIB}svg4-dbg                = "${libdir}/.debug/lib${QT_LIBRARY_NAME}Svg*"
FILES_${QT_BASE_LIB}test4                   = "${libdir}/lib${QT_LIBRARY_NAME}Test.so.*"
FILES_${QT_BASE_LIB}test4-dev               = "${libdir}/lib${QT_LIBRARY_NAME}Test.so ${includedir}/${QT_DIR_NAME}/QtTest* ${libdir}/pkgconfig/${QT_LIBRARY_NAME}Test.pc"
FILES_${QT_BASE_LIB}test4-dbg               = "${libdir}/.debug/lib${QT_LIBRARY_NAME}Test*"
FILES_${QT_BASE_LIB}xml4                    = "${libdir}/lib${QT_LIBRARY_NAME}Xml.so.*"
FILES_${QT_BASE_LIB}xml4-dev                = "${libdir}/lib${QT_LIBRARY_NAME}Xml.so ${includedir}/${QT_DIR_NAME}/QtXml* ${libdir}/pkgconfig/${QT_LIBRARY_NAME}Xml.pc"
FILES_${QT_BASE_LIB}xml4-dbg                = "${libdir}/.debug/lib${QT_LIBRARY_NAME}Xml*"
FILES_${QT_BASE_LIB}designer4               = "${libdir}/lib${QT_LIBRARY_NAME}Designer.so.*"
FILES_${QT_BASE_LIB}designer4-dev           = "${libdir}/lib${QT_LIBRARY_NAME}Designer.so ${includedir}/${QT_DIR_NAME}/QtDesigner* ${libdir}/pkgconfig/${QT_LIBRARY_NAME}Designer.pc"
FILES_${QT_BASE_LIB}designer4-dbg           = "${libdir}/.debug/lib${QT_LIBRARY_NAME}Designer*"
FILES_${QT_BASE_LIB}designercomponents4     = "${libdir}/lib${QT_LIBRARY_NAME}DesignerComponents.so.*"
FILES_${QT_BASE_LIB}designercomponents4-dev = "${libdir}/lib${QT_LIBRARY_NAME}DesignerComponents.so"
FILES_${QT_BASE_LIB}designercomponents4-dbg = "${libdir}/.debug/lib${QT_LIBRARY_NAME}DesignerComponents*"
FILES_${QT_BASE_LIB}3support4               = "${libdir}/lib${QT_LIBRARY_NAME}3Support.so.*"
FILES_${QT_BASE_LIB}3support4-dev           = "${libdir}/lib${QT_LIBRARY_NAME}3Support.so ${includedir}/${QT_DIR_NAME}/Qt3Support*  ${libdir}/pkgconfig/${QT_LIBRARY_NAME}3Support.pc"
FILES_${QT_BASE_LIB}3support4-dbg           = "${libdir}/.debug/lib${QT_LIBRARY_NAME}3Support*"
FILES_${QT_BASE_LIB}assistantclient4        = "${libdir}/lib${QT_LIBRARY_NAME}AssistantClient.so.*"
FILES_${QT_BASE_LIB}assistantclient4-dev    = "${libdir}/lib${QT_LIBRARY_NAME}AssistantClient.so ${includedir}/${QT_DIR_NAME}/QtAssistant*  ${libdir}/pkgconfig/${QT_LIBRARY_NAME}AssistantClient.pc"
FILES_${QT_BASE_LIB}assistantclient4-dbg    = "${libdir}/.debug/lib${QT_LIBRARY_NAME}AssistantClient*"
FILES_${QT_BASE_LIB}script4                 = "${libdir}/lib${QT_LIBRARY_NAME}Script.so.*"
FILES_${QT_BASE_LIB}script4-dev             = "${libdir}/lib${QT_LIBRARY_NAME}Script.so ${includedir}/${QT_DIR_NAME}/QtScript*  ${libdir}/pkgconfig/${QT_LIBRARY_NAME}Script.pc"
FILES_${QT_BASE_LIB}script4-dbg             = "${libdir}/.debug/lib${QT_LIBRARY_NAME}Script*"
FILES_${QT_BASE_LIB}dbus4                   = "${libdir}/lib${QT_LIBRARY_NAME}DBus.so.*"
FILES_${QT_BASE_LIB}dbus4-dev               = "${libdir}/lib${QT_LIBRARY_NAME}DBus.sp ${includedir}/${QT_DIR_NAME}/QtDBus*  ${libdir}/pkgconfig/${QT_LIBRARY_NAME}DBus.pc"
FILES_${QT_BASE_LIB}dbus4-dbg               = "${libdir}/.debug/lib${QT_LIBRARY_NAME}DBus*"
FILES_${QT_BASE_LIB}opengl4                 = "${libdir}/lib${QT_LIBRARY_NAME}OpenGL.so.*"
FILES_${QT_BASE_LIB}opengl4-dev             = "${libdir}/lib${QT_LIBRARY_NAME}OpenGL.so ${includedir}/${QT_DIR_NAME}/QtOpenGL* ${libdir}/pkgconfig/${QT_LIBRARY_NAME}OpenGL.pc"
FILES_${QT_BASE_LIB}opengl4-dbg             = "${libdir}/.debug/lib${QT_LIBRARY_NAME}OpenGL*"
FILES_${QT_BASE_LIB}uitools4-dev            = "${libdir}/lib${QT_LIBRARY_NAME}* ${includedir}/${QT_DIR_NAME}/QtUiTools* ${libdir}/pkgconfig/${QT_LIBRARY_NAME}UiTools.pc"


FILES_${QT_BASE_NAME}-plugins-accessible   = "${libdir}/${QT_DIR_NAME}/plugins/accessible/*.so"
FILES_${QT_BASE_NAME}-plugins-codecs       = "${libdir}/${QT_DIR_NAME}/plugins/codecs/*.so"
FILES_${QT_BASE_NAME}-plugins-designer     = "${libdir}/${QT_DIR_NAME}/plugins/designer/*.so"
FILES_${QT_BASE_NAME}-plugins-imageformats = "${libdir}/${QT_DIR_NAME}/plugins/imageformats/*.so"
FILES_${QT_BASE_NAME}-plugins-sqldrivers   = "${libdir}/${QT_DIR_NAME}/plugins/sqldrivers/*.so"
FILES_${QT_BASE_NAME}-plugins-inputmethods = "${libdir}/${QT_DIR_NAME}/plugins/inputmethods/*.so"
FILES_${QT_BASE_NAME}-plugins-iconengines  = "${libdir}/${QT_DIR_NAME}/plugins/iconengines/*.so"

FILES_${QT_BASE_NAME}-assistant            = "${bindir}/*assistant*"
FILES_${QT_BASE_NAME}-designer             = "${bindir}/*designer*"
FILES_${QT_BASE_NAME}-linguist             = "${bindir}/*linguist* ${bindir}/lrelease ${bindir}/lupdate ${bindir}/qm2ts"
FILES_${QT_BASE_NAME}-pixeltool            = "${bindir}/pixeltool"
FILES_${QT_BASE_NAME}-dbus                 = "${bindir}/qdbus ${bindir}/qdbusxml2cpp ${bindir}/qdbuscpp2xml ${bindir}/qdbusviewer"

FILES_${QT_BASE_NAME}-common               = "${bindir}/qtconfig"
FILES_${QT_BASE_NAME}-examples             = "${bindir}/${QT_BASE_NAME}-examples/*"
FILES_${QT_BASE_NAME}-demos                = "${bindir}/qtdemo ${bindir}/${QT_BASE_NAME}-demos/*"

FILES_${QT_BASE_NAME}-fonts                = "${libdir}/fonts"


FILES_${QT_BASE_NAME}-documentation = "${docdir}/${QT_DIR_NAME}/html/*"

python populate_packages_prepend() {
	translationdir = bb.data.expand('${datadir}/${QT_DIR_NAME}/translations/', d)
	do_split_packages(d, translationdir, '^qt_(.*)\.qm$', '${QT_DIR_NAME}-translation-%s', '{PN} translation for %s', extra_depends='' )
}


do_install() {
    oe_runmake install INSTALL_ROOT=${D}

    # These are host binaries, we should only use them in staging
    rm -rf ${D}/${bindir}
    rm -rf ${D}/${datadir}/${QT_DIR_NAME}/mkspecs

    install -d ${D}/${libdir}/fonts
    touch ${D}/${libdir}/fonts/fontdir
}
