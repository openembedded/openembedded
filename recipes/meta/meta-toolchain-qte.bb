# Qt Embedded toolchain

require meta-toolchain.bb

TOOLCHAIN_HOST_TASK = "task-qte-toolchain-host"
TOOLCHAIN_TARGET_TASK = "task-qte-toolchain-target"

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
       echo 'export OE_QMAKE_MOC=${prefix}/${layout_bindir}/moc4' >> $script
       echo 'export OE_QMAKE_UIC=${prefix}/${layout_bindir}/uic4' >> $script

       # Repack SDK with new environment-setup
       cd ${SDK_OUTPUT}
       fakeroot tar cfj ${SDK_DEPLOY}/${TOOLCHAIN_OUTPUTNAME}.tar.bz2 .
}
