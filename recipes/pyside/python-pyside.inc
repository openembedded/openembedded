QTV = "4.7"
DESCRIPTION = "Python Bindings for Qt ${QTV}"
DEPENDS = "apiextractor-native generatorrunner-native shiboken-native libshiboken"
RDEPENDS_${pn} = "python-core"
PROVIDES = "python-pyside"
INC_PR = "r1"

SRC_URI = " \
 http://www.pyside.org/files/pyside-qt${QTV}+${PV}.tar.bz2;name=code \
 file://FindQt4.cmake \
 file://MacroPushRequiredVars.cmake \
"
S = "${WORKDIR}/pyside-qt${QTV}+${PV}"

RDEPENDS_${PN} = " \
 python-lang \
"

export HOST_SYS
export BUILD_SYS

# NOTE this should be reworked when a x11 version of qt4 is needed
inherit qt4e cmake pkgconfig python-dir

EXTRA_OECMAKE = " \
	-DQT_LIBRARY_DIR=${STAGING_TARGET_LIBDIR} \
	-DQT_INSTALL_LIBS=${OE_QMAKE_LIBDIR_QT} \
	-DQT_MOC_EXECUTABLE=${OE_QMAKE_MOC} \
	-DQT_UIC_EXECUTABLE=${OE_QMAKE_UIC} \
	-DQT_UIC3_EXECUTABLE=${OE_QMAKE_UIC3} \
	-DQT_RCC_EXECUTABLE=${OE_QMAKE_RCC} \
	-DQT_QMAKE_EXECUTABLE=${OE_QMAKE_QMAKE} \
	-DQT_MKSPECS_DIR=${STAGING_DATADIR}/qt4/mkspecs \
	-DQT_DBUSXML2CPP_EXECUTABLE=${OE_QMAKE_QDBUSXML2CPP} \
	-DQT_DBUSCPP2XML_EXECUTABLE=${OE_QMAKE_QDBUSCPP2XML} \
	-DQT_INCLUDE_DIR=${OE_QMAKE_INCDIR_QT} \
	-DQT_QTCORE_INCLUDE_DIR=${OE_QMAKE_INCDIR_QT}/QtCore \
	-DQT_LIBINFIX=${QT_LIBINFIX} \
	-DQT_DIR_NAME=${QT_DIR_NAME} \
	-DCMAKE_LIBRARY_PATH=${STAGING_TARGET_LIBDIR} \
	-DCMAKE_TOOLCHAIN_SYSTEM_ROOT:PATH=${STAGING_DIR_TARGET} \
	-DCMAKE_STAGING_DIR_TARGET:PATH=${STAGING_DIR_TARGET} \
	-DCMAKE_STAGING_DIR_NATIVE:PATH=${STAGING_DIR_NATIVE} \
"

do_generate_toolchain_file_append() {
	# even search in shiboken cmake modules path for modules
	echo "set( CMAKE_MODULE_PATH ${STAGING_LIBDIR}/cmake/Shiboken-${PV} \${CMAKE_MODULE_PATH} )" >> ${WORKDIR}/toolchain.cmake
	echo "set( CMAKE_MODULE_PATH ${S}/cmake/Modules \${CMAKE_MODULE_PATH} )" >> ${WORKDIR}/toolchain.cmake
}

do_configure_prepend() {
	mkdir -p ${S}/cmake/Modules
	cp ${WORKDIR}/FindQt4.cmake ${S}/cmake/Modules/FindQt4.cmake
	cp ${WORKDIR}/MacroPushRequiredVars.cmake ${S}/cmake/Modules/MacroPushRequiredVars.cmake
}

FILES_${PN} =+ " \
	${libdir}/${PYTHON_DIR}/site-packages/PySide/*.so \
	${libdir}/${PYTHON_DIR}/site-packages/PySide/*.py \
"
FILES_${PN}-dbg =+ "${libdir}/${PYTHON_DIR}/site-packages/PySide/.debug"
FILES_${PN}-dev =+ " \
	${datadir}/PySide/typesystems \
	${libdir}/cmake \
"
