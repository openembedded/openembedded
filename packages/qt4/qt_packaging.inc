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

def qt_default_dev(name):
    return """${libdir}/lib${QT_LIBRARY_NAME}%(name)s.la 
              ${libdir}/lib${QT_LIBRARY_NAME}%(name)s.prl
              ${libdir}/lib${QT_LIBRARY_NAME}%(name)s.so
              ${includedir}/${QT_DIR_NAME}/Qt%(name)s*
              ${libdir}/pkgconfig/${QT_LIBRARY_NAME}%(name)s.pc""" % locals()


FILES_${QT_BASE_LIB}core4                   = "${libdir}/lib${QT_LIBRARY_NAME}Core.so.*"
FILES_${QT_BASE_LIB}core4-dev               = "${@qt_default_dev('Core')}"
FILES_${QT_BASE_LIB}core4-dbg               = "${libdir}/.debug/lib${QT_LIBRARY_NAME}Core*"
FILES_${QT_BASE_LIB}gui4                    = "${libdir}/lib${QT_LIBRARY_NAME}Gui.so.*"
FILES_${QT_BASE_LIB}gui4-dev                = "${@qt_default_dev('Gui')}"
FILES_${QT_BASE_LIB}gui4-dbg                = "${libdir}/.debug/lib${QT_LIBRARY_NAME}Gui*"
FILES_${QT_BASE_LIB}network4                = "${libdir}/lib${QT_LIBRARY_NAME}Network.so.*"
FILES_${QT_BASE_LIB}network4-dev            = "${@qt_default_dev('Network')}"
FILES_${QT_BASE_LIB}network4-dbg            = "${libdir}/.debug/lib${QT_LIBRARY_NAME}Network*"
FILES_${QT_BASE_LIB}sql4                    = "${libdir}/lib${QT_LIBRARY_NAME}Sql.so.*"
FILES_${QT_BASE_LIB}sql4-dev                = "${@qt_default_dev('Sql')}"
FILES_${QT_BASE_LIB}sql4-dbg                = "${libdir}/.debug/lib${QT_LIBRARY_NAME}Sql*"
FILES_${QT_BASE_LIB}svg4                    = "${libdir}/lib${QT_LIBRARY_NAME}Svg.so.*"
FILES_${QT_BASE_LIB}svg4-dev                = "${@qt_default_dev('Svg')}"
FILES_${QT_BASE_LIB}svg4-dbg                = "${libdir}/.debug/lib${QT_LIBRARY_NAME}Svg*"
FILES_${QT_BASE_LIB}test4                   = "${libdir}/lib${QT_LIBRARY_NAME}Test.so.*"
FILES_${QT_BASE_LIB}test4-dev               = "${@qt_default_dev('Test')}"
FILES_${QT_BASE_LIB}test4-dbg               = "${libdir}/.debug/lib${QT_LIBRARY_NAME}Test*"
FILES_${QT_BASE_LIB}xml4                    = "${libdir}/lib${QT_LIBRARY_NAME}Xml.so.*"
FILES_${QT_BASE_LIB}xml4-dev                = "${@qt_default_dev('Xml')}"
FILES_${QT_BASE_LIB}xml4-dbg                = "${libdir}/.debug/lib${QT_LIBRARY_NAME}Xml*"
FILES_${QT_BASE_LIB}designer4               = "${libdir}/lib${QT_LIBRARY_NAME}Designer.so.*"
FILES_${QT_BASE_LIB}designer4-dev           = "${@qt_default_dev('Designer')}"
FILES_${QT_BASE_LIB}designer4-dbg           = "${libdir}/.debug/lib${QT_LIBRARY_NAME}Designer*"
FILES_${QT_BASE_LIB}designercomponents4     = "${libdir}/lib${QT_LIBRARY_NAME}DesignerComponents.so.*"
FILES_${QT_BASE_LIB}designercomponents4-dev = "${@qt_default_dev('DesignerComponents')}"
FILES_${QT_BASE_LIB}designercomponents4-dbg = "${libdir}/.debug/lib${QT_LIBRARY_NAME}DesignerComponents*"
FILES_${QT_BASE_LIB}3support4               = "${libdir}/lib${QT_LIBRARY_NAME}3Support.so.*"
FILES_${QT_BASE_LIB}3support4-dev           = "${@qt_default_dev('3Support')}"
FILES_${QT_BASE_LIB}3support4-dbg           = "${libdir}/.debug/lib${QT_LIBRARY_NAME}3Support*"
FILES_${QT_BASE_LIB}assistantclient4        = "${libdir}/lib${QT_LIBRARY_NAME}AssistantClient.so.*"
FILES_${QT_BASE_LIB}assistantclient4-dev    = "${@qt_default_dev('AssistantClient')} ${includedir}/${QT_DIR_NAME}/QtAssistant*"
FILES_${QT_BASE_LIB}assistantclient4-dbg    = "${libdir}/.debug/lib${QT_LIBRARY_NAME}AssistantClient*"
FILES_${QT_BASE_LIB}script4                 = "${libdir}/lib${QT_LIBRARY_NAME}Script.so.*"
FILES_${QT_BASE_LIB}script4-dev             = "${@qt_default_dev('Script')}"
FILES_${QT_BASE_LIB}script4-dbg             = "${libdir}/.debug/lib${QT_LIBRARY_NAME}Script*"
FILES_${QT_BASE_LIB}dbus4                   = "${libdir}/lib${QT_LIBRARY_NAME}DBus.so.*"
FILES_${QT_BASE_LIB}dbus4-dev               = "${@qt_default_dev('DBus')}"
FILES_${QT_BASE_LIB}dbus4-dbg               = "${libdir}/.debug/lib${QT_LIBRARY_NAME}DBus*"
FILES_${QT_BASE_LIB}opengl4                 = "${libdir}/lib${QT_LIBRARY_NAME}OpenGL.so.*"
FILES_${QT_BASE_LIB}opengl4-dev             = "${@qt_default_dev('OpenGL')}"
FILES_${QT_BASE_LIB}opengl4-dbg             = "${libdir}/.debug/lib${QT_LIBRARY_NAME}OpenGL*"
FILES_${QT_BASE_LIB}uitools4-dev            = "${libdir}/lib${QT_LIBRARY_NAME}UiTools* ${includedir}/${QT_DIR_NAME}/QtUiTools* ${libdir}/pkgconfig/${QT_LIBRARY_NAME}UiTools.pc"


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
