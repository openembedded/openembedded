NONDEV_PACKAGES = "${QT_BASE_LIB}core4 ${QT_BASE_LIB}gui4 ${QT_BASE_LIB}network4  \
             ${QT_BASE_LIB}sql4 ${QT_BASE_LIB}svg4 ${QT_BASE_LIB}test4 ${QT_BASE_LIB}xml4 \
             ${QT_BASE_LIB}designer4 ${QT_BASE_LIB}designercomponents4 \
             ${QT_BASE_LIB}3support4 ${QT_BASE_LIB}assistantclient4 ${QT_BASE_LIB}script4 \
             ${QT_BASE_LIB}dbus4 \
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

DEV_PACKAGES += "${QT_BASE_LIB}core4-dev ${QT_BASE_LIB}core4-dbg \
             ${QT_BASE_LIB}gui4-dev ${QT_BASE_LIB}gui4-dbg \
             ${QT_BASE_LIB}network4-dev ${QT_BASE_LIB}network4-dbg \
             ${QT_BASE_LIB}sql4-dev ${QT_BASE_LIB}sql4-dbg \
             ${QT_BASE_LIB}svg4-dev ${QT_BASE_LIB}svg4-dbg \
             ${QT_BASE_LIB}test4-dev ${QT_BASE_LIB}test4-dbg \
             ${QT_BASE_LIB}xml4-dev ${QT_BASE_LIB}xml4-dbg \
             ${QT_BASE_LIB}designer4-dev ${QT_BASE_LIB}designer4-dbg \
             ${QT_BASE_LIB}designercomponents4-dev ${QT_BASE_LIB}designercomponents4-dbg \
             ${QT_BASE_LIB}3support4-dev ${QT_BASE_LIB}3support4-dbg \
             ${QT_BASE_LIB}assistantclient4-dev ${QT_BASE_LIB}assistantclient4-dbg \
             ${QT_BASE_LIB}script4-dev ${QT_BASE_LIB}script4-dbg \
             ${QT_BASE_LIB}dbus4-dev ${QT_BASE_LIB}dbus4-dbg "

PACKAGES += "${DEV_PACKAGES} ${NONDEV_PACKAGES}"

ALLOW_EMPTY_${PN} = "1"
ALLOW_EMPTY_${PN}-dev = "1"
FILES_${PN} = ""
FILES_${PN}-dev = ""
RDEPENDS_${PN} = "${NONDEV_PACKAGES}"
RDEPENDS_${PN}-dev = "${DEV_PACKAGES}"


FILES_${QT_BASE_LIB}core4                   = "${libdir}/${QT_LIBRARY_NAME}Core.so.*"
FILES_${QT_BASE_LIB}core4-dev               = "${libdir}/${QT_LIBRARY_NAME}Core.so"
FILES_${QT_BASE_LIB}core4-dbg               = "${libdir}/.debug/${QT_LIBRARY_NAME}Core*"
FILES_${QT_BASE_LIB}gui4                    = "${libdir}/${QT_LIBRARY_NAME}Gui.so.*"
FILES_${QT_BASE_LIB}gui4-dev                = "${libdir}/${QT_LIBRARY_NAME}Gui.so"
FILES_${QT_BASE_LIB}gui4-dbg                = "${libdir}/.debug/${QT_LIBRARY_NAME}Gui*"
FILES_${QT_BASE_LIB}network4                = "${libdir}/${QT_LIBRARY_NAME}Network.so.*"
FILES_${QT_BASE_LIB}network4-dev            = "${libdir}/${QT_LIBRARY_NAME}Network.so"
FILES_${QT_BASE_LIB}network4-dbg            = "${libdir}/.debug/${QT_LIBRARY_NAME}Network*"
FILES_${QT_BASE_LIB}sql4                    = "${libdir}/${QT_LIBRARY_NAME}Sql.so.*"
FILES_${QT_BASE_LIB}sql4-dev                = "${libdir}/${QT_LIBRARY_NAME}Sql.so"
FILES_${QT_BASE_LIB}sql4-dbg                = "${libdir}/.debug/${QT_LIBRARY_NAME}Sql*"
FILES_${QT_BASE_LIB}svg4                    = "${libdir}/${QT_LIBRARY_NAME}Svg.so.*"
FILES_${QT_BASE_LIB}svg4-dev                = "${libdir}/${QT_LIBRARY_NAME}Svg.so"
FILES_${QT_BASE_LIB}svg4-dbg                = "${libdir}/.debug/${QT_LIBRARY_NAME}Svg*"
FILES_${QT_BASE_LIB}test4                   = "${libdir}/${QT_LIBRARY_NAME}Test.so.*"
FILES_${QT_BASE_LIB}test4-dev               = "${libdir}/${QT_LIBRARY_NAME}Test.so"
FILES_${QT_BASE_LIB}test4-dbg               = "${libdir}/.debug/${QT_LIBRARY_NAME}Test"
FILES_${QT_BASE_LIB}xml4                    = "${libdir}/${QT_LIBRARY_NAME}Xml.so.*"
FILES_${QT_BASE_LIB}xml4-dev                = "${libdir}/${QT_LIBRARY_NAME}Xml.so"
FILES_${QT_BASE_LIB}xml4-dbg                = "${libdir}/.debug/${QT_LIBRARY_NAME}Xml*"
FILES_${QT_BASE_LIB}designer4               = "${libdir}/${QT_LIBRARY_NAME}Designer.so.*"
FILES_${QT_BASE_LIB}designer4-dev           = "${libdir}/${QT_LIBRARY_NAME}Designer.so"
FILES_${QT_BASE_LIB}designer4-dbg           = "${libdir}/.debug/${QT_LIBRARY_NAME}Designer*"
FILES_${QT_BASE_LIB}designercomponents4     = "${libdir}/${QT_LIBRARY_NAME}DesignerComponents.so.*"
FILES_${QT_BASE_LIB}designercomponents4-dev = "${libdir}/${QT_LIBRARY_NAME}DesignerComponents.so"
FILES_${QT_BASE_LIB}designercomponents4-dbg = "${libdir}/.debug/${QT_LIBRARY_NAME}DesignerComponents*"
FILES_${QT_BASE_LIB}3support4               = "${libdir}/${QT_LIBRARY_NAME}3Support.so.*"
FILES_${QT_BASE_LIB}3support4-dev           = "${libdir}/${QT_LIBRARY_NAME}3Support.so"
FILES_${QT_BASE_LIB}3support4-dbg           = "${libdir}/.debug/${QT_LIBRARY_NAME}3Support*"
FILES_${QT_BASE_LIB}assistantclient4        = "${libdir}/${QT_LIBRARY_NAME}AssistantClient.so.*"
FILES_${QT_BASE_LIB}assistantclient4-dev    = "${libdir}/${QT_LIBRARY_NAME}AssistantClient.so"
FILES_${QT_BASE_LIB}assistantclient4-dbg    = "${libdir}/.debug/${QT_LIBRARY_NAME}AssistantClient*"
FILES_${QT_BASE_LIB}script4                 = "${libdir}/${QT_LIBRARY_NAME}Script.so.*"
FILES_${QT_BASE_LIB}script4-dev             = "${libdir}/${QT_LIBRARY_NAME}Script.so"
FILES_${QT_BASE_LIB}script4-dbg             = "${libdir}/.debug/${QT_LIBRARY_NAME}Script*"
FILES_${QT_BASE_LIB}dbus4                   = "${libdir}/${QT_LIBRARY_NAME}DBus.so.*"
FILES_${QT_BASE_LIB}dbus4-dev               = "${libdir}/${QT_LIBRARY_NAME}DBus.so"
FILES_${QT_BASE_LIB}dbus4-dbg               = "${libdir}/.debug/${QT_LIBRARY_NAME}DBus*"

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

FILES_${PN}-dev               += "${bindir}/rcc ${bindir}/uic* ${bindir}/moc ${bindir}/qmake ${bindir}/syncqt \
                                  ${bindir}/qt3to4 ${bindir}/findtr"
FILES_${PN}-dbg                += "${bindir}/*/.debug ${plugindir}/.debug"

python populate_packages_prepend() {
	translationdir = bb.data.expand('${datadir}/qtopia/translations/', d)
	do_split_packages(d, translationdir, '^qt_(.*)\.qm$', 'qtopia-translation-%s', 'Qtopia translation for %s', extra_depends='' )
}
