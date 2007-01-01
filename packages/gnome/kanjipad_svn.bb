DESCRIPTION = "KanjiPad is a very simple program for handwriting recognition"
LICENSE = "GPLv2"

DEPENDS = "gtk perl-native"

PV = "0.0+svn${SRCDATE}"

inherit pkgconfig 

SRC_URI = "svn://svn.gnome.org/svn/${PN}/;module=trunk"

S = "${WORKDIR}/trunk"

export CFLAGS += '-DKP_LIBDIR="${libdir}/kanjipad" -DBINDIR="${bindir}" `pkg-config --cflags gtk+-2.0` '




