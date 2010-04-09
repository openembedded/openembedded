require gnuplot.inc

SRC_URI = "${SOURCEFORGE_MIRROR}/gnuplot/${PN}-${PV}.tar.gz;name=archive \
       http://www.mneuroth.de/privat/zaurus/qtplot-0.2.tar.gz \
       file://subdirs.patch;patch=1 \
	   file://gnuplot.desktop \
	   file://gnuplot.png"

SRC_URI[archive.md5sum] = "e708665bd512153ad5c35252fe499059"
SRC_URI[archive.sha256sum] = "00de2c54a05920a5d2dc68f668990b0b84a96105d92a932d91600dd53f156b2a"

