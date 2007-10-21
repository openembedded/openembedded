DEPENDS_prepend = "${@["qtopia-core ", ""][(bb.data.getVar('PN', d, 1) == 'qtopia-core')]}"
inherit qmake2

#
# override variables set by qmake-base to compile QtopiaCore apps
#
export OE_QMAKE_INCDIR_QT = "${STAGING_INCDIR}/qtopiacore4"
export OE_QMAKE_LIBDIR_QT = "${STAGING_LIBDIR}/qtopiacore4/"
export OE_QMAKE_LIBS_QT = "qt"
export OE_QMAKE_LIBS_X11 = ""
EXTRA_QMAKEVARS_POST += "LIBS+=-lQtNetwork "
