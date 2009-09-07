require midori.inc

DEPENDS += "python-native librsvg"

SRC_URI = "\
	http://goodies.xfce.org/releases/midori/midori-${PV}.tar.bz2\
	file://ua-iphone.patch;patch=1\
"

PR = "r0"

CC += "-lstdc++"

