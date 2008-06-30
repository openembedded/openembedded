DESCRIPTION = "LaserTraq is a package to enable you to use a laserpointer in connection with a camera as input device."
LICENSE = "GPL"
DEPENDS = "gstreamer gtk+"

SRC_URI = "http://lasertraq.googlecode.com/files/lasertraq-0.8-r213.tar.bz2"

inherit autotools

S = "${WORKDIR}/lasertraq/${PN}"

