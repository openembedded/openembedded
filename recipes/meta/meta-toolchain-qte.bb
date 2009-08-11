# Qt Embedded toolchain
PR = "r2"
TOOLCHAIN_HOST_TASK = "task-qte-toolchain-host"
TOOLCHAIN_TARGET_TASK = "task-qte-toolchain-target"

require meta-toolchain.bb
SDK_SUFFIX = "toolchain-qte"


QT_DIR_NAME = "qtopia"

do_populate_sdk_append() {
       script = "${SDK_OUTPUT}/${prefix}/environment-setup"
       touch $script
       echo 'export OE_QMAKE_CC=${TARGET_SYS}-gcc' >> $script
       echo 'export OE_QMAKE_CXX=${TARGET_SYS}-g++' >> $script
       echo 'export OE_QMAKE_LINK=${TARGET_SYS}-g++' >> $script
       echo 'export OE_QMAKE_LIBDIR_QT=${prefix}/${TARGET_SYS}/${layout_libdir}' >> $script
       echo 'export OE_QMAKE_INCDIR_QT=${prefix}/${TARGET_SYS}/${layout_includedir}/${QT_DIR_NAME}' >> $script
       echo 'export OE_QMAKE_MOC=${prefix}/bin/moc4' >> $script
       echo 'export OE_QMAKE_UIC=${prefix}/bin/uic4' >> $script
       echo 'export OE_QMAKE_UIC3=${prefix}/bin/uic34' >> $script
       echo 'export OE_QMAKE_RCC=${prefix}/bin/rcc4' >> $script
       echo 'export OE_QMAKE_QDBUSCPP2XML=${prefix}/bin/qdbuscpp2xml4' >> $script
       echo 'export OE_QMAKE_QDBUSXML2CPP=${prefix}/bin/qdbusxml2cpp4' >> $script
       echo 'export OE_QMAKE_QT_CONFIG=${prefix}/${TARGET_SYS}/${layout_datadir}/${QT_DIR_NAME}/mkspecs/qconfig.pri' >> $script
       echo 'export QMAKESPEC=${prefix}/${TARGET_SYS}/${layout_datadir}/${QT_DIR_NAME}/mkspecs/linux-g++' >> $script

       # Repack SDK with new environment-setup
       cd ${SDK_OUTPUT}
       fakeroot tar cfj ${SDK_DEPLOY}/${TOOLCHAIN_OUTPUTNAME}.tar.bz2 .
}
