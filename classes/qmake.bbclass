inherit qmake_base

DEPENDS_prepend = "qmake-native "

export OE_QMAKE_UIC="${STAGING_BINDIR_NATIVE}/uic"
export OE_QMAKE_MOC="${STAGING_BINDIR_NATIVE}/moc"
export OE_QMAKE_QMAKE="${STAGING_BINDIR_NATIVE}/qmake"
export OE_QMAKE_CXXFLAGS="-fno-exceptions -fno-rtti ${CXXFLAGS}"
export OE_QMAKE_LINK="${CCLD}"
export OE_QMAKE_INCDIR_QT="${QTDIR}/include"
export OE_QMAKE_LIBDIR_QT="${QTDIR}/lib"
export OE_QMAKE_LIBS_QT="qte"
export OE_QMAKE_LIBS_X11=""

