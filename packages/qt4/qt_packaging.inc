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
             ${QT_BASE_LIB}uitools4-dev"

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
    return """${libdir}/libQt%(name)s${QT_LIBINFIX}.la
              ${libdir}/libQt%(name)s${QT_LIBINFIX}.prl
              ${libdir}/libQt%(name)s${QT_LIBINFIX}.so
              ${includedir}/${QT_DIR_NAME}/Qt%(name)s*
              ${libdir}/pkgconfig/Qt%(name)s${QT_LIBINFIX}.pc""" % locals()


FILES_${QT_BASE_LIB}core4                   = "${libdir}/libQtCore${QT_LIBINFIX}.so.*"
FILES_${QT_BASE_LIB}core4-dev               = "${@qt_default_dev('Core')}"
FILES_${QT_BASE_LIB}core4-dbg               = "${libdir}/.debug/libQtCore*"
FILES_${QT_BASE_LIB}gui4                    = "${libdir}/libQtGui${QT_LIBINFIX}.so.*"
FILES_${QT_BASE_LIB}gui4-dev                = "${@qt_default_dev('Gui')}"
FILES_${QT_BASE_LIB}gui4-dbg                = "${libdir}/.debug/libQtGui*"
FILES_${QT_BASE_LIB}network4                = "${libdir}/libQtNetwork${QT_LIBINFIX}.so.*"
FILES_${QT_BASE_LIB}network4-dev            = "${@qt_default_dev('Network')}"
FILES_${QT_BASE_LIB}network4-dbg            = "${libdir}/.debug/libQtNetwork${QT_LIBINFIX}*"
FILES_${QT_BASE_LIB}sql4                    = "${libdir}/libQtSql${QT_LIBINFIX}.so.*"
FILES_${QT_BASE_LIB}sql4-dev                = "${@qt_default_dev('Sql')}"
FILES_${QT_BASE_LIB}sql4-dbg                = "${libdir}/.debug/libQtSql*"
FILES_${QT_BASE_LIB}svg4                    = "${libdir}/libQtSvg${QT_LIBINFIX}.so.*"
FILES_${QT_BASE_LIB}svg4-dev                = "${@qt_default_dev('Svg')}"
FILES_${QT_BASE_LIB}svg4-dbg                = "${libdir}/.debug/libQtSvg*"
FILES_${QT_BASE_LIB}test4                   = "${libdir}/libQtTest${QT_LIBINFIX}.so.*"
FILES_${QT_BASE_LIB}test4-dev               = "${@qt_default_dev('Test')}"
FILES_${QT_BASE_LIB}test4-dbg               = "${libdir}/.debug/libQtTest*"
FILES_${QT_BASE_LIB}xml4                    = "${libdir}/libQtXml${QT_LIBINFIX}.so.*"
FILES_${QT_BASE_LIB}xml4-dev                = "${@qt_default_dev('Xml')}"
FILES_${QT_BASE_LIB}xml4-dbg                = "${libdir}/.debug/libQtXml*"
FILES_${QT_BASE_LIB}designer4               = "${libdir}/libQtDesigner${QT_LIBINFIX}.so.*"
FILES_${QT_BASE_LIB}designer4-dev           = "${@qt_default_dev('Designer')}"
FILES_${QT_BASE_LIB}designer4-dbg           = "${libdir}/.debug/libQtDesigner*"
FILES_${QT_BASE_LIB}designercomponents4     = "${libdir}/libQtDesignerComponents${QT_LIBINFIX}.so.*"
FILES_${QT_BASE_LIB}designercomponents4-dev = "${@qt_default_dev('DesignerComponents')}"
FILES_${QT_BASE_LIB}designercomponents4-dbg = "${libdir}/.debug/libQtDesignerComponents*"
FILES_${QT_BASE_LIB}3support4               = "${libdir}/libQt3Support${QT_LIBINFIX}.so.*"
FILES_${QT_BASE_LIB}3support4-dev           = "${@qt_default_dev('3Support')}"
FILES_${QT_BASE_LIB}3support4-dbg           = "${libdir}/.debug/libQt3Support*"
FILES_${QT_BASE_LIB}assistantclient4        = "${libdir}/libQtAssistantClient${QT_LIBINFIX}.so.*"
FILES_${QT_BASE_LIB}assistantclient4-dev    = "${@qt_default_dev('AssistantClient')} ${includedir}/${QT_DIR_NAME}/QtAssistant*"
FILES_${QT_BASE_LIB}assistantclient4-dbg    = "${libdir}/.debug/libQtAssistantClient*"
FILES_${QT_BASE_LIB}script4                 = "${libdir}/libQtScript${QT_LIBINFIX}.so.*"
FILES_${QT_BASE_LIB}script4-dev             = "${@qt_default_dev('Script')}"
FILES_${QT_BASE_LIB}script4-dbg             = "${libdir}/.debug/libQtScript*"
FILES_${QT_BASE_LIB}dbus4                   = "${libdir}/libQtDBus${QT_LIBINFIX}.so.*"
FILES_${QT_BASE_LIB}dbus4-dev               = "${@qt_default_dev('DBus')}"
FILES_${QT_BASE_LIB}dbus4-dbg               = "${libdir}/.debug/libQtDBus*"
FILES_${QT_BASE_LIB}opengl4                 = "${libdir}/libQtOpenGL${QT_LIBINFIX}.so.*"
FILES_${QT_BASE_LIB}opengl4-dev             = "${@qt_default_dev('OpenGL')}"
FILES_${QT_BASE_LIB}opengl4-dbg             = "${libdir}/.debug/libQtOpenGL*"
FILES_${QT_BASE_LIB}uitools4-dev            = "${libdir}/libQtUiTools* ${includedir}/${QT_DIR_NAME}/QtUiTools* ${libdir}/pkgconfig/QtUiTools${QT_LIBINFIX}.pc"


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
FILES_${QT_BASE_NAME}-examples             = "${bindir}/${QT_DIR_NAME}/examples/*"
FILES_${QT_BASE_NAME}-demos                = "${bindir}/qtdemo ${bindir}/${QT_DIR_NAME}/demos/*"

FILES_${QT_BASE_NAME}-fonts                = "${libdir}/fonts"

python populate_packages_prepend() {
	translationdir = bb.data.expand('${datadir}/${QT_DIR_NAME}/translations/', d)
	do_split_packages(d, translationdir, '^qt_(.*)\.qm$', '${QT_DIR_NAME}-translation-%s', '{PN} translation for %s', extra_depends='' )
}


do_install() {
    oe_runmake install INSTALL_ROOT=${D}

    # These are host binaries, we should only use them in staging
    rm -rf ${D}/${bindir}/qmake

    # XXX, FIXME, TODO: package the demos and examples properly
    rm -rf ${D}/${bindir}/${QT_DIR_NAME}
    rm -rf ${D}/${datadir}/${QT_DIR_NAME}/mkspecs

    install -d ${D}/${libdir}/fonts
    touch ${D}/${libdir}/fonts/fontdir
}
