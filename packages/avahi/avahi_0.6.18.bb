require avahi.inc
PR="r1"

DEPENDS =+ "gtk+ libglade"

PACKAGES =+ "libavahi-ui"
FILES_libavahi-ui = "${libdir}/libavahi-ui.so.*"

EXTRA_OECONF = "--with-distro=debian --disable-gdbm --disable-mono --disable-monodoc --disable-qt3 --disable-qt4 --disable-python"

