require gnuplot.inc

SRCDATE = "20080328"
PV = "4.3.0+cvs${SRCDATE}"
PR = "r0"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "cvs://anonymous@gnuplot.cvs.sourceforge.net/cvsroot/${PN};module=${PN} \
           http://www.mneuroth.de/privat/zaurus/qtplot-0.2.tar.gz;name=qtplot \
           file://subdirs.patch;patch=1 \
           file://term.patch;patch=1 \
           file://gnuplot.desktop \
           file://gnuplot.png"

S = "${WORKDIR}/${PN}"

do_configure_prepend() {
           ./prepare
}

SRC_URI[qtplot.md5sum] = "0a481885a496092c77eb4017540b5cf6"
SRC_URI[qtplot.sha256sum] = "6df317183ff62cc82f3dcf88207a267cd6478cb5147f55d7530c94f1ad5f4132"
