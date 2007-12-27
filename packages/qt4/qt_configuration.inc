require qt4_arch.inc
QT_ARCH := "${@qt_arch(d)}"
QT_ENDIAN = "${@qt_endian(d)}"

QT_CONFIG_FLAGS += "-release -no-cups -no-accessibility -reduce-relocations \
                    -shared -no-nas-sound -no-sm -no-nis \
                    -qt-gif -system-libjpeg -system-libpng -system-zlib \
                     -no-sql-ibase -no-sql-mysql -no-sql-odbc -no-sql-psql -no-sql-sqlite -no-sql-sqlite2 \
                    -no-pch -qdbus -stl -glib"

EXTRA_OEMAKE = "-e"

EXTRA_ENV = 'QMAKE="${STAGING_BINDIR_NATIVE}/qmake2 -after \
             INCPATH+=${STAGING_INCDIR}/freetype2 LIBS+=-L${STAGING_LIBDIR}" \
             QMAKESPEC="${QMAKESPEC}" LINK="${CXX} -Wl,-rpath-link,${STAGING_LIBDIR}" \
             AR="${TARGET_PREFIX}ar cqs" \
             MOC="${STAGING_BINDIR_NATIVE}/moc4" UIC="${STAGING_BINDIR_NATIVE}/uic4" MAKE="make -e"'

export QT_CONF_PATH="${WORKDIR}/qt.conf"

do_configure() {
    unset QMAKESPEC
    unset QTDIR
    ln -sf ${STAGING_BINDIR_NATIVE}/qmake2 bin/qmake
    ln -s linux-g++ mkspecs/${TARGET_OS}-oe-g++

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

    echo yes | ./configure -v \
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

#
# Fixup some pkgconfig files
# moc_location=/home/zecke/gmit/dela_build/git/openembedded-gmit.zecke/build/oetmp/work/arm-oabi-angstrom-linux/qtopia-core-4.3.0-r2/qtopia-core-opensource-src-4.3.0/bin/moc
# uic_location=/home/zecke/gmit/dela_build/git/openembedded-gmit.zecke/build/oetmp/work/arm-oabi-angstrom-linux/qtopia-core-4.3.0-r2/qtopia-core-opensource-src-4.3.0/bin/uic
#
# Libs: -L${libdir} -lQtNetwork -L/home/zecke/gmit/dela_build/git/openembedded-gmit.zecke/build/oetmp/staging/arm-angstrom-linux/lib -L/home/zecke/gmit/dela_build/git/openembedded-gmit.zecke/build/oetmp/work/arm-oabi-angstrom-linux/qtopia-core-4.3.0-r2/qtopia-core-opensource-src-4.3.0/lib  $(LIBS_EXTRA) -lQtCore -L/home/zecke/gmit/dela_build/git/openembedded-gmit.zecke/build/oetmp/staging/arm-angstrom-linux/lib -L/home/zecke/gmit/dela_build/git/openembedded-gmit.zecke/build/oetmp/work/arm-oabi-angstrom-linux/qtopia-core-4.3.0-r2/qtopia-core-opensource-src-4.3.0/lib -lm -lrt -lpthread -ldl
#
do_compile_append() {
    cd ${S}/lib/pkgconfig
    sed -i s#"-L${S}/lib"##g *.pc
    sed -i s#"moc_location=${S}/bin/moc"#moc_location=${STAGING_BINDIR}/moc4# *.pc
    sed -i s#"uic_location=${S}/bin/uic"#uic_location=${STAGING_BINDIR}/uic4# *.pc
}
