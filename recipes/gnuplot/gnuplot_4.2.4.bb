require gnuplot.inc

PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/gnuplot/${PN}-${PV}.tar.gz \
           http://www.mneuroth.de/privat/zaurus/qtplot-0.2.tar.gz \
	   file://subdirs.patch;patch=1 \
           file://term.patch;patch=1 \
	   file://gnuplot.desktop \
	   file://gnuplot.png"
