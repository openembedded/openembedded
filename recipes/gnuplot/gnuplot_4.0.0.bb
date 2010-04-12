require gnuplot.inc

PR = "r5"

SRC_URI = "ftp://ftp.gnuplot.info/pub/gnuplot/gnuplot-${PV}.tar.gz;name=archive \
	   file://subdirs.patch;patch=1 \
	   file://debian-separate-x11-package.patch;patch=1 \
	   http://www.mneuroth.de/privat/zaurus/qtplot-0.2.tar.gz;name=qtplot \
	   file://matrix.patch;patch=1 \
   	   file://term.patch;patch=1 \
	   file://gnuplot.desktop \
	   file://gnuplot.png"

SRC_URI[archive.md5sum] = "66258443d9f93cc4f46b147dac33e63a"
SRC_URI[archive.sha256sum] = "a77ad7cb08b2551dacbaa0bb02e561fddb6b9f4a0f3d45eb1c38be219955ea48"
SRC_URI[qtplot.md5sum] = "0a481885a496092c77eb4017540b5cf6"
SRC_URI[qtplot.sha256sum] = "6df317183ff62cc82f3dcf88207a267cd6478cb5147f55d7530c94f1ad5f4132"
