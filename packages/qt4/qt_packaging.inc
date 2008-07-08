NONDEV_PACKAGES += "${QT_BASE_LIB}core4 ${QT_BASE_LIB}gui4 ${QT_BASE_LIB}network4  \
             ${QT_BASE_LIB}sql4 ${QT_BASE_LIB}svg4 ${QT_BASE_LIB}test4 ${QT_BASE_LIB}xml4 \
             ${QT_BASE_LIB}designer4 ${QT_BASE_LIB}designercomponents4 \
             ${QT_BASE_LIB}3support4 ${QT_BASE_LIB}assistantclient4 ${QT_BASE_LIB}script4 \
             ${QT_BASE_LIB}dbus4 ${QT_BASE_LIB}opengl4 \
             ${QT_BASE_LIB}help ${QT_BASE_LIB}clucene ${QT_BASE_LIB}webkit \
             ${QT_BASE_NAME}-assistant ${QT_BASE_NAME}-common \
             ${QT_BASE_NAME}-designer \
             ${QT_BASE_NAME}-demos ${QT_BASE_NAME}-examples \
             ${QT_BASE_NAME}-linguist \
             ${QT_BASE_NAME}-pixeltool ${QT_BASE_NAME}-dbus \
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
             ${QT_BASE_LIB}help-dev \
             ${QT_BASE_LIB}clucene-dev \
             ${QT_BASE_LIB}webkit-dev \
             "

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
             ${QT_BASE_LIB}opengl4-dbg \
             ${QT_BASE_LIB}help-dbg \
             ${QT_BASE_LIB}clucene-dbg \
             ${QT_BASE_LIB}webkit-dbg \
             "


PACKAGES += "${DEV_PACKAGES} ${NONDEV_PACKAGES} ${DBG_PACKAGES}"

ALLOW_EMPTY_${PN} = "1"
FILES_${PN}     = ""
FILES_${PN}-dev = " ${includedir}/${QT_DIR_NAME}/Qt/*"
FILES_${PN}-dbg = "${bindir}/*/.debug "
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
FILES_${QT_BASE_LIB}help                    = "${libdir}/libQtHelp${QT_LIBINFIX}.so.*"
FILES_${QT_BASE_LIB}help-dev                = "${@qt_default_dev('Help')}"
FILES_${QT_BASE_LIB}help-dbg                = "${libdir}/.debug/libQtHelp*"
FILES_${QT_BASE_LIB}clucene                 = "${libdir}/libQtCLucene${QT_LIBINFIX}.so.*"
FILES_${QT_BASE_LIB}clucene-dev             = "${@qt_default_dev('CLucene')}"
FILES_${QT_BASE_LIB}clucene-dbg             = "${libdir}/.debug/libQtCLucene*"
FILES_${QT_BASE_LIB}webkit                  = "${libdir}/libQtWebKit${QT_LIBINFIX}.so.*"
FILES_${QT_BASE_LIB}webkit-dev              = "${@qt_default_dev('WebKit')}"
FILES_${QT_BASE_LIB}webkit-dbg              = "${libdir}/.debug/libQtWebKit*"

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
	translation_dir = bb.data.expand('${datadir}/${QT_DIR_NAME}/translations/', d)
	translation_name = bb.data.expand('${QT_BASE_NAME}-translation-%s', d)
	do_split_packages(d, translation_dir, '^qt_(.*)\.qm$', translation_name, '{PN} translation for %s', extra_depends='' )

	phrasebook_dir = bb.data.expand('${datadir}/${QT_DIR_NAME}/phrasebooks/', d)
	phrasebook_name = bb.data.expand('${QT_BASE_NAME}-phrasebook-%s', d)
	do_split_packages(d, phrasebook_dir, '^(.*)\.qph$', phrasebook_name, '{PN} phrasebook for %s', extra_depends='' )

	# Package all the plugins and their -dbg version and create a meta package
	import os
	def qtopia_split(path, name, glob):
	    """
	    Split the package into a normal and -dbg package and then add the
	    new packages to the meta package.
	    """
	    plugin_dir     = bb.data.expand('${libdir}/${QT_DIR_NAME}/plugins/%s/' % path, d)
	    if not os.path.exists("%s%s" % (bb.data.expand('${D}',d), plugin_dir)):
		bb.note("The path does not exist:", bb.data.expand('${D}', d), plugin_dir)
		return

            plugin_name    = bb.data.expand('${QT_BASE_NAME}-plugin-%s-%%s' % name, d)
            dev_packages = []
            dev_hook = lambda file,pkg,b,c,d:dev_packages.append((file,pkg))
            do_split_packages(d, plugin_dir,     glob, plugin_name,     '{PN} %s for %%s' % name, extra_depends='', hook=dev_hook)
            # Create a -dbg package as well
            plugin_dir_dbg     = bb.data.expand('${libdir}/${QT_DIR_NAME}/plugins/%s/.debug' % path, d)
            packages = bb.data.getVar('PACKAGES',d)
            for (file,package) in dev_packages:
                packages = "%s %s-dbg" % (packages, package)
                file_name = os.path.join(plugin_dir_dbg, os.path.basename(file))
                bb.data.setVar("FILES_%s-dbg" % package, file_name, d)
                bb.data.setVar("DESCRIPTION_%s-dbg" % package, "{PN} %s for %s" % (name, package), d) 

            bb.data.setVar('PACKAGES', packages, d)

	qtopia_split('accessible',  'accessible',  '^libq(.*)\.so$')
	qtopia_split('codecs',      'codec',       '^libq(.*)\.so$')
	qtopia_split('decorations', 'decoration',  '^libqdecoration(.*)\.so$')
	qtopia_split('designer',    'designer',    '^lib(.*)\.so$')
	qtopia_split('gfxdrivers',  'gfxdriver',   '^libqgfx(.*)\.so$')
	qtopia_split('mousedrivers','mousedriver', '^libq(.*)mousedriver\.so$')
	qtopia_split('iconengines', 'iconengine',  '^libq(.*)\.so$')
	qtopia_split('imageformats','imageformat', '^libq(.*)\.so$')
	qtopia_split('inputmethods','inputmethod', '^libq(.*)\.so$')
	qtopia_split('sqldrivers',  'sqldriver',   '^libq(.*)\.so$')
	qtopia_split('styles',      'style',       '^libq(.*)\.so$')
}


do_install() {
    oe_runmake install INSTALL_ROOT=${D}

    # These are host binaries, we should only use them in staging
    rm -rf ${D}/${bindir}/qmake

    # XXX, FIXME, TODO: package the demos and examples properly
    rm -rf ${D}/${bindir}/${QT_DIR_NAME}
    rm -rf ${D}/${datadir}/${QT_DIR_NAME}/mkspecs

    # fix some .la and .pc files
    sed -i s#"moc_location=${STAGING_BINDIR}/moc4$"#"moc_location=${bindir}/moc4"# ${D}/${libdir}/pkgconfig/Qt*.pc
    sed -i s#"uic_location=${STAGING_BINDIR}/uic4$"#"uic_location=${bindir}/uic4"# ${D}/${libdir}/pkgconfig/Qt*.pc
    sed -i s#'$(OE_QMAKE_LIBS_X11)'#"${OE_QMAKE_LIBS_X11}"#g ${D}/${libdir}/pkgconfig/Qt*.pc
    sed -i s#-L${STAGING_LIBDIR}##g ${D}${libdir}/pkgconfig/Qt*.pc

    sed -i s#-L${STAGING_LIBDIR}#-L${libdir}#g ${D}${libdir}/libQt*.la
    sed -i s#'$(OE_QMAKE_LIBS_X11)'#"${OE_QMAKE_LIBS_X11}"#g ${D}/${libdir}/libQt*.la

    install -d ${D}/${libdir}/fonts
    touch ${D}/${libdir}/fonts/fontdir
}
