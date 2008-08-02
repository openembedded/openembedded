require gnuplot.inc

PR = "r5"

SRC_URI = "ftp://ftp.gnuplot.info/pub/gnuplot/gnuplot-${PV}.tar.gz \
	   file://subdirs.patch;patch=1 \
	   file://debian-separate-x11-package.patch;patch=1 \
	   http://www.mneuroth.de/privat/zaurus/qtplot-0.2.tar.gz \
	   file://matrix.patch;patch=1 \
   	   file://term.patch;patch=1 \
	   file://gnuplot.desktop \
	   file://gnuplot.png"
