require kanjipad.inc

DEPENDS += "perl-native"
PV = "2.0.0+svn${SRCDATE}"
PR = "r1"

SRC_URI = "svn://svn.gnome.org/svn/${PN}/;module=trunk"
S = "${WORKDIR}/trunk"

do_compile_prepend() {
	export CFLAGS='${TARGET_CFLAGS}  -DFOR_PILOT_COMPAT -DKP_LIBDIR="${libdir}/kanjipad" -DBINDIR="${bindir}" `pkg-config --cflags gtk+-2.0` `pkg-config --cflags glib-2.0`'
}
