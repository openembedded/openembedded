require mingw-gcc-canadian-cross_${PV}.bb
require gcc-canadian-cross-initial.inc

SRC_URI = "\
	${SOURCEFORGE_MIRROR}/mingw/gcc-core-${PV}-src.tar.gz;name=core \
	file://includedir.patch;patch=1 \
"
