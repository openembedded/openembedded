require gnuplot.inc

PV = "4.3.0+cvs${SRCDATE}"
PR = "r0"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "cvs://anonymous@gnuplot.cvs.sourceforge.net/cvsroot/${PN};module=${PN} \
           http://www.mneuroth.de/privat/zaurus/qtplot-0.2.tar.gz \
           file://subdirs.patch;patch=1 \
           file://term.patch;patch=1 \
           file://gnuplot.desktop \
           file://gnuplot.png"

S = "${WORKDIR}/${PN}"

do_configure_prepend() {
           ./prepare
}
