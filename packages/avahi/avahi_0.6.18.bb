require avahi.inc
PR = "r2"

DEPENDS =+ "gtk+ libglade"

PACKAGES =+ "libavahi-ui libavahi-ui-dev libavahi-ui-dbg"
FILES_libavahi-ui = "${libdir}/libavahi-ui.so.*"
FILES_libavahi-ui-dev = "${libdir}/libavahi-ui.*"
FILES_libavahi-ui-dbg = "${libdir}/.debug/libavahi-ui*"

EXTRA_OECONF = "--with-distro=debian --disable-gdbm --disable-mono --disable-monodoc --disable-qt3 --disable-qt4 --disable-python"

