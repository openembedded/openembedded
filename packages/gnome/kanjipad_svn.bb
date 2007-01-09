DESCRIPTION = "KanjiPad is a very simple program for handwriting recognition"
LICENSE = "GPLv2"

DEPENDS = "gtk+ perl-native"

PV = "2.0.0+svn${SRCDATE}"

inherit pkgconfig 

SRC_URI = "svn://svn.gnome.org/svn/${PN}/;module=trunk"

S = "${WORKDIR}/trunk"

do_compile_prepend() {
	export CFLAGS='${TARGET_CFLAGS}  -DFOR_PILOT_COMPAT -DKP_LIBDIR="${libdir}/kanjipad" -DBINDIR="${bindir}" `pkg-config --cflags gtk+-2.0` `pkg-config --cflags glib-2.0`'
}



