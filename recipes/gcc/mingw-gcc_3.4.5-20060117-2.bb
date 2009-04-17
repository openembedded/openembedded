PR = "r1"
DESCRIPTION = "The GNU Compiler Collection - MinGW port"
HOMEPAGE = "http://www.mingw.org/"
SECTION = "devel"
LICENSE = "GPL"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_mingw32 = "1"

inherit autotools gettext

require gcc-common.inc
require gcc-package-sdk.inc

SRC_URI = "${SOURCEFORGE_MIRROR}/mingw/gcc-core-${PV}-src.tar.gz \
	   ${SOURCEFORGE_MIRROR}/mingw/gcc-g++-${PV}-src.tar.gz \
	   ${SOURCEFORGE_MIRROR}/mingw/gcc-g77-${PV}-src.tar.gz \
	   ${SOURCEFORGE_MIRROR}/mingw/gcc-java-${PV}-src.tar.gz \
	   ${SOURCEFORGE_MIRROR}/mingw/gcc-objc-${PV}-src.tar.gz \
	   ${SOURCEFORGE_MIRROR}/mingw/gcc-ada-${PV}-src.tar.gz \
	   file://includedir.patch;patch=1 \
"


require mingw-gcc-build.inc
