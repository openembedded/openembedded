LICENSE = "GPL"

inherit qt4x11 cmake mime

PV = "4.1+svnr${SRCPV}"
SRCREV = "856719"
SRC_URI = "svn://anonsvn.kde.org/home/kde/branches/KDE/4.1;module=${PN};proto=svn"

# OE lacks some native qt4 tools, so we use the ones form the host :/
EXTRA_OECMAKE = "-DQT_LIBRARY_DIR=${OE_QMAKE_LIBDIR_QT} \
                 -DQT_INSTALL_LIBS=${OE_QMAKE_LIBDIR_QT} \
		 -DQT_INCLUDE_DIR=${OE_QMAKE_INCDIR_QT} \
		 -DQT_MOC_EXECUTABLE=${OE_QMAKE_MOC} \
		 -DQT_UIC_EXECUTABLE=${OE_QMAKE_UIC} \
		 -DQT_UIC3_EXECUTABLE=${OE_QMAKE_UIC3} \
		 -DQT_RCC_EXECUTABLE=${OE_QMAKE_RCC} \
		 -DQT_QMAKE_EXECUTABLE=${OE_QMAKE_QMAKE} \
		 -DQT_QTCORE_INCLUDE_DIR=${OE_QMAKE_INCDIR_QT}/QtCore \ 
		 -DQT_DBUSXML2CPP_EXECUTABLE=/usr/bin/qdbusxml2cpp \
		 -DQT_DBUSCPP2XML_EXECUTABLE=/usr/bin/qdbuscpp2xml \
		"


S = "${WORKDIR}/${PN}"


do_install_append() {
	install -d ${D}/${libdir}/qt4
	mv ${D}/${STAGING_DIR_TARGET}/qt4/plugins* ${D}/${libdir}/qt4 || true
}

FILES_${PN} += "${libdir}/qt4 \
                ${datadir}/mime/packages \
		${datadir}/dbus-1 \
		${datadir}/config \
               "

FILES_${PN}-dbg += "${libdir}/qt4/.debug \
                    ${libdir}/qt4/*/.debug \
		    ${libdir}/qt4/*/*/.debug"


AUTOTOOLS_STAGE_PKGCONFIG = "1"
do_stage() {
	autotools_stage_all
}	
