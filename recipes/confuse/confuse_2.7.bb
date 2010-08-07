DESCRIPTION = "Library for parsing configuration files."
HOMEPAGE = "http://www.nongnu.org/confuse/"
LICENSE = "LGPL"
SECTION = "libs"

SRC_URI = "http://download.savannah.gnu.org/releases/confuse/confuse-${PV}.tar.gz \
	  "
inherit autotools binconfig pkgconfig lib_package

EXTRA_OECONF = "--enable-shared"

BBCLASSEXTEND = "native"
SRC_URI[md5sum] = "45932fdeeccbb9ef4228f1c1a25e9c8f"
SRC_URI[sha256sum] = "e32574fd837e950778dac7ade40787dd2259ef8e28acd6ede6847ca895c88778"
