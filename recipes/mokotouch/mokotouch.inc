DESCRIPTION = "MokoTouch a finger friendly QT4-based iphone like GUI for OpenMoko"
HOMEPAGE = "http://th30z.netsons.org/mokotouch/"
SECTION = "openmoko/applications"
LICENSE = "GPL"
DEPENDS = "gstreamer qt4-x11-free"

PR = "r1"

SRC_URI = "http://th30z.netsons.org/mokotouch/data/mokotouch-2-aug-2009.tar.bz2"

S = "${WORKDIR}/MokoTouch-Project"
D = "${WORKDIR}/image"

EXTRA_QMAKEVARS_POST += "INCLUDEPATH+=${OE_QMAKE_INCDIR_QT}/Qt"

inherit autotools qt4x11 distutils-base pkgconfig lib_package
