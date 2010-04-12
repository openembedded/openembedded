require gnuplot.inc

PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/gnuplot/${PN}-${PV}.tar.gz;name=archive \
           http://www.mneuroth.de/privat/zaurus/qtplot-0.2.tar.gz;name=qtplot \
	   file://subdirs.patch;patch=1 \
           file://term.patch;patch=1 \
	   file://gnuplot.desktop \
	   file://gnuplot.png"

SRC_URI[archive.md5sum] = "3cde3b9232a2d81715bbaf75e1c87ecc"
SRC_URI[archive.sha256sum] = "2a20701410a21307c404a9d10ad9fdf699bb92fa0a919797213208d80b080913"
SRC_URI[qtplot.md5sum] = "0a481885a496092c77eb4017540b5cf6"
SRC_URI[qtplot.sha256sum] = "6df317183ff62cc82f3dcf88207a267cd6478cb5147f55d7530c94f1ad5f4132"
