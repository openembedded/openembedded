inherit qmake_base

DEPENDS += " qt4-tools-native freetype jpeg libpng zlib dbus openssl glib-2.0 gstreamer gst-plugins-base"

require qt4_arch.inc
QT_ARCH := "${@qt_arch(d)}"
QT_ENDIAN = "${@qt_endian(d)}"

QT_CONFIG_FLAGS += "-release -no-cups -no-accessibility -reduce-relocations \
                    -shared -no-nas-sound -no-sm -no-nis \
                    -qt-gif -system-libjpeg -system-libpng -system-zlib \
                    -no-sql-ibase -no-sql-mysql -no-sql-odbc -no-sql-psql -no-sql-sqlite -no-sql-sqlite2 \
                    -no-pch -qdbus -stl -glib -phonon -webkit"

EXTRA_OEMAKE = "-e"

EXTRA_ENV = 'QMAKE="${STAGING_BINDIR_NATIVE}/qmake2 -after \
             INCPATH+=${STAGING_INCDIR}/freetype2 LIBS+=-L${STAGING_LIBDIR}" \
             QMAKESPEC="${QMAKESPEC}" LINK="${CXX} -Wl,-rpath-link,${STAGING_LIBDIR}" \
             AR="${TARGET_PREFIX}ar cqs" \
             MOC="${STAGING_BINDIR_NATIVE}/moc4" UIC="${STAGING_BINDIR_NATIVE}/uic4" MAKE="make -e"'

export QT_CONF_PATH="${WORKDIR}/qt.conf"

# Library packages
QT_LIB_NAMES = "Qt3Support QtAssistantClient QtCLucene QtCore QtDBus QtDesigner QtDesignerComponents QtGui QtHelp QtNetwork QtOpenGL QtScript QtScriptTools QtSql QtSvg QtTest QtUiTools QtWebKit QtXml phonon"
python __anonymous () {
    import bb

    lib_packages = []
    dev_packages = []
    dbg_packages = []
    for name in bb.data.getVar("QT_LIB_NAMES", d, 1).split():
        pkg = "${QT_BASE_LIB}"+ name.lower().replace("qt", "") + "4"
        # NOTE: the headers for QtAssistantClient are different
        incname = name.replace("QtAssistantClient", "QtAssistant")
        bb.data.setVar("FILES_%s" % pkg, "%(pkg)s ${libdir}/lib%(name)s${QT_LIBINFIX}.so.*" % locals(), d)
        bb.data.setVar("FILES_%s-dev" % pkg, """${libdir}/lib%(name)s${QT_LIBINFIX}.prl
                  ${libdir}/lib%(name)s${QT_LIBINFIX}.a
                  ${libdir}/lib%(name)s${QT_LIBINFIX}.la
                  ${libdir}/lib%(name)s${QT_LIBINFIX}.so
                  ${includedir}/${QT_DIR_NAME}/%(incname)s
                  ${libdir}/pkgconfig/%(name)s${QT_LIBINFIX}.pc""" % locals(), d)
        bb.data.setVar("FILES_%s-dbg" % pkg, "${libdir}/.debug/lib%(name)s${QT_LIBINFIX}.so.*" % locals(), d)
        lib_packages.append(pkg)
        dev_packages.append("%s-dev" % pkg)
        dbg_packages.append("%s-dbg" % pkg)
    bb.data.setVar("LIB_PACKAGES", " ".join(lib_packages), d)
    bb.data.setVar("DEV_PACKAGES", " ".join(dev_packages), d)
    bb.data.setVar("DBG_PACKAGES", " ".join(dbg_packages), d)
}

OTHER_PACKAGES = "\
             ${QT_BASE_NAME}-assistant \
             ${QT_BASE_NAME}-common \
             ${QT_BASE_NAME}-dbus \
             ${QT_BASE_NAME}-demos \
             ${QT_BASE_NAME}-designer \
             ${QT_BASE_NAME}-examples \
             ${QT_BASE_NAME}-fonts \
             ${QT_BASE_NAME}-linguist \
             ${QT_BASE_NAME}-pixeltool"

PACKAGES += "${LIB_PACKAGES} ${DEV_PACKAGES} ${DBG_PACKAGES} ${OTHER_PACKAGES}"
PACKAGES_DYNAMIC = "${QT_BASE_NAME}-plugin-*  ${QT_BASE_NAME}-translation-*"

ALLOW_EMPTY_${PN} = "1"
FILES_${PN}     = ""
FILES_${PN}-dev = " ${includedir}/${QT_DIR_NAME}/Qt/*"
FILES_${PN}-dbg = "${bindir}/*/.debug "
RRECOMMENDS_${PN} = "${LIB_PACKAGES} ${OTHER_PACKAGES}"
RRECOMMENDS_${PN}-dev = "${DEV_PACKAGES}"
RRECOMMENDS_${PN}-dbg = "${DBG_PACKAGES}"

FILES_${QT_BASE_NAME}-assistant            = "${bindir}/*assistant*"
FILES_${QT_BASE_NAME}-common               = "${bindir}/qtconfig"
FILES_${QT_BASE_NAME}-dbus                 = "${bindir}/qdbus ${bindir}/qdbusxml2cpp ${bindir}/qdbuscpp2xml ${bindir}/qdbusviewer"
FILES_${QT_BASE_NAME}-demos                = "${bindir}/qtdemo ${bindir}/${QT_DIR_NAME}/demos/*"
FILES_${QT_BASE_NAME}-designer             = "${bindir}/*designer*"
FILES_${QT_BASE_NAME}-examples             = "${bindir}/${QT_DIR_NAME}/examples/*"
FILES_${QT_BASE_NAME}-fonts                = "${libdir}/fonts"
FILES_${QT_BASE_NAME}-linguist             = "${bindir}/*linguist* ${bindir}/lrelease ${bindir}/lupdate ${bindir}/qm2ts"
FILES_${QT_BASE_NAME}-pixeltool            = "${bindir}/pixeltool"


do_configure() {
    unset QMAKESPEC
    unset QTDIR
    ln -sf ${STAGING_BINDIR_NATIVE}/qmake2 bin/qmake
    ln -sf linux-g++ mkspecs/${TARGET_OS}-oe-g++
    cp -f ${WORKDIR}/g++.conf ${WORKDIR}/linux.conf mkspecs/common/

    echo "[Paths]"                                 > $QT_CONF_PATH
    echo "Prefix=${prefix}"                       >> $QT_CONF_PATH
    echo "Documentation=${docdir}/${QT_DIR_NAME}" >> $QT_CONF_PATH
    echo "Headers=${includedir}/${QT_DIR_NAME}"   >> $QT_CONF_PATH
    echo "Libraries=${libdir}"                    >> $QT_CONF_PATH
    echo "Binaries=${bindir}"                     >> $QT_CONF_PATH
    echo "Plugins=${libdir}/${QT_DIR_NAME}/plugins" >> $QT_CONF_PATH
    echo "Data=${datadir}/${QT_DIR_NAME}"         >> $QT_CONF_PATH
    echo "Translations=${datadir}/${QT_DIR_NAME}/translations" >> $QT_CONF_PATH
    echo "Settings=${sysconfdir}/${QT_DIR_NAME}"  >> $QT_CONF_PATH
    echo "Examples=${bindir}/${QT_DIR_NAME}/examples" >> $QT_CONF_PATH
    echo "Demos=${bindir}/${QT_DIR_NAME}/demos"   >> $QT_CONF_PATH

    (echo o; echo yes) | ./configure -v \
            -prefix ${prefix} \
            -bindir ${bindir} \
            -libdir ${libdir} \
            -datadir ${datadir}/${QT_DIR_NAME} \
            -sysconfdir ${sysconfdir}/${QT_DIR_NAME} \
            -docdir ${docdir}/${QT_DIR_NAME} \
            -headerdir ${includedir}/${QT_DIR_NAME} \
            -plugindir ${libdir}/${QT_DIR_NAME}/plugins \
            -translationdir ${datadir}/${QT_DIR_NAME}/translations \
            -examplesdir ${bindir}/${QT_DIR_NAME}/examples \
            -demosdir ${bindir}/${QT_DIR_NAME}/demos \
            -platform ${TARGET_OS}-oe-g++ \
            -xplatform ${TARGET_OS}-oe-g++ \
            -embedded ${QT_ARCH} ${QT_ENDIAN} -fast \
            -crossarch ${QT_ARCH} \
            ${QT_CONFIG_FLAGS} -fast \
            -L${STAGING_LIBDIR} -I${STAGING_INCDIR} \
            -I${STAGING_INCDIR}/freetype2
}

do_compile() {
    unset CFLAGS CXXFLAGS
    install -m 0755 ${STAGING_BINDIR_NATIVE}/rcc4 ${S}/bin/rcc
    install -m 0755 ${STAGING_BINDIR_NATIVE}/moc4 ${S}/bin/moc
    install -m 0755 ${STAGING_BINDIR_NATIVE}/uic4 ${S}/bin/uic

    oe_runmake ${EXTRA_ENV}
}

python populate_packages_prepend() {
	translation_dir = bb.data.expand('${datadir}/${QT_DIR_NAME}/translations/', d)
	translation_name = bb.data.expand('${QT_BASE_NAME}-translation-%s', d)
	do_split_packages(d, translation_dir, '^qt_(.*)\.qm$', translation_name, '${PN} translation for %s', extra_depends='' )

	phrasebook_dir = bb.data.expand('${datadir}/${QT_DIR_NAME}/phrasebooks/', d)
	phrasebook_name = bb.data.expand('${QT_BASE_NAME}-phrasebook-%s', d)
	do_split_packages(d, phrasebook_dir, '^(.*)\.qph$', phrasebook_name, '${PN} phrasebook for %s', extra_depends='' )

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
		do_split_packages(d, plugin_dir,     glob, plugin_name,     '${PN} %s for %%s' % name, extra_depends='', hook=dev_hook)
		# Create a -dbg package as well
		plugin_dir_dbg     = bb.data.expand('${libdir}/${QT_DIR_NAME}/plugins/%s/.debug' % path, d)
		packages = bb.data.getVar('PACKAGES',d)
		for (file,package) in dev_packages:
			packages = "%s %s-dbg" % (packages, package)
			file_name = os.path.join(plugin_dir_dbg, os.path.basename(file))
			bb.data.setVar("FILES_%s-dbg" % package, file_name, d)
			bb.data.setVar("DESCRIPTION_%s-dbg" % package, "${PN} %s for %s" % (name, package), d) 

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
	qtopia_split('script',      'script',      '^libqtscript(.*)\.so$')
	qtopia_split('styles',      'style',       '^libq(.*)\.so$')
	qtopia_split('phonon_backend',      'phonon-backend',       '^libphonon_(.*)\.so$')
}

do_install() {
    oe_runmake install INSTALL_ROOT=${D}

    # These are host binaries, we should only use them in staging
    rm -rf ${D}/${bindir}/qmake

    # XXX, FIXME, TODO: package the demos and examples properly
    rm -rf ${D}/${bindir}/${QT_DIR_NAME}
    rm -rf ${D}/${datadir}/${QT_DIR_NAME}/mkspecs

    # fix pkgconfig, libtool and prl files
    sed -i -e s#-L${S}/lib##g \
           -e s#-L${STAGING_LIBDIR}##g \
           -e s#-L${libdir}##g \
           -e s#'$(OE_QMAKE_LIBS_X11)'#"${OE_QMAKE_LIBS_X11}"#g \
           ${D}${libdir}/*.la ${D}${libdir}/*.prl ${D}${libdir}/pkgconfig/*.pc

    # fix pkgconfig files
    sed -i -e s#"moc_location=.*$"#"moc_location=${bindir}/moc4"# \
           -e s#"uic_location=.*$"#"uic_location=${bindir}/uic4"# \
           ${D}${libdir}/pkgconfig/*.pc

    install -d ${D}/${libdir}/fonts
    touch ${D}/${libdir}/fonts/fontdir
}

STAGE_TEMP = "${WORKDIR}/temp-staging"
do_stage() {
    rm -rf ${STAGE_TEMP}
    mkdir -p ${STAGE_TEMP}
    oe_runmake install INSTALL_ROOT=${STAGE_TEMP}

    # fix pkgconfig, libtool and prl files
    sed -i -e s#-L${S}/lib##g \
           -e s#-L${STAGING_LIBDIR}##g \
           -e s#-L${libdir}##g \
           -e s#'$(OE_QMAKE_LIBS_X11)'#"${OE_QMAKE_LIBS_X11}"#g \
           ${STAGE_TEMP}${libdir}/*.la ${STAGE_TEMP}${libdir}/*.prl ${STAGE_TEMP}${libdir}/pkgconfig/*.pc

    # fix pkgconfig files
    sed -i -e s#"moc_location=.*$"## \
           -e s#"uic_location=.*$"## \
           ${STAGE_TEMP}/${libdir}/pkgconfig/*.pc

    # fix libtool files
    sed -i -e s#installed=yes#installed=no#g ${STAGE_TEMP}/${libdir}/*.la

    # install headers
    install -d ${STAGING_INCDIR}
    cp -pPRf ${STAGE_TEMP}/${includedir}/* ${STAGING_INCDIR}/

    # install libraries
    install -d ${STAGING_LIBDIR}
    for i in ${STAGE_TEMP}/${libdir}/*.prl; do
        cp -pPRf $i ${STAGING_LIBDIR}
        cp -pPRf ${STAGE_TEMP}/${libdir}/$(basename $i .prl).la ${STAGING_LIBDIR} || true
        oe_libinstall -C ${STAGE_TEMP}/${libdir} -a $(basename $i .prl) ${STAGING_LIBDIR} || true
        oe_libinstall -C ${STAGE_TEMP}/${libdir} -so $(basename $i .prl) ${STAGING_LIBDIR} || true
    done

    # install pkgconfig files
    install -d ${STAGING_LIBDIR}/pkgconfig
    cp -pPRf ${STAGE_TEMP}/${libdir}/pkgconfig/*.pc ${STAGING_LIBDIR}/pkgconfig/

    # install mkspecs
    install -d ${STAGING_DATADIR}/${QT_DIR_NAME}/mkspecs
    cp -pPRf ${STAGE_TEMP}/${datadir}/${QT_DIR_NAME}/mkspecs/* ${STAGING_DATADIR}/${QT_DIR_NAME}/mkspecs/

    rm -rf ${STAGE_TEMP}

    # FIXME: install symlinks to tools?
    #install -d ${STAGING_DATADIR}/${QT_DIR_NAME}/bin
    #ln -sf ${STAGING_BINDIR_NATIVE}/qmake2 ${STAGING_DATADIR}/${QT_DIR_NAME}/bin/qmake
    #for qttool in moc uic uic3 rcc lrelease lupdate; do
    #     ln -sf ${STAGING_BINDIR_NATIVE}/${qttool}4 ${STAGING_DATADIR}/${QT_DIR_NAME}/bin/${qttool}
    #done
}

