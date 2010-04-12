PR = "r1"
DESCRIPTION = "The GNU Compiler Collection - MinGW port"
HOMEPAGE = "http://www.mingw.org/"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_mingw32 = "1"

inherit autotools gettext

require gcc-common.inc
require gcc-package-sdk.inc

SRC_URI = "${SOURCEFORGE_MIRROR}/mingw/gcc-core-${PV}-src.tar.gz;name=core \
	   ${SOURCEFORGE_MIRROR}/mingw/gcc-g++-${PV}-src.tar.gz;name=g++ \
	   ${SOURCEFORGE_MIRROR}/mingw/gcc-g77-${PV}-src.tar.gz;name=g77 \
	   ${SOURCEFORGE_MIRROR}/mingw/gcc-java-${PV}-src.tar.gz;name=java \
	   ${SOURCEFORGE_MIRROR}/mingw/gcc-objc-${PV}-src.tar.gz;name=objc \
	   ${SOURCEFORGE_MIRROR}/mingw/gcc-ada-${PV}-src.tar.gz;name=ada \
	   file://includedir.patch;patch=1 \
"


require mingw-gcc-build.inc

SRC_URI[core.md5sum] = "d0dc9d57d493889bc1ca88b127290b9d"
SRC_URI[core.sha256sum] = "a21c2f48bb48d62935ee955ac8fa318658861f6316f30feb3cdec5337abf7f05"
SRC_URI[g++.md5sum] = "ca81c8420ab9d1d05ff9c73a9d4f7d63"
SRC_URI[g++.sha256sum] = "d54078fdccaa3776927b3931c15b880c43e76cb6a0fb59594d1b85cfc89356e9"
SRC_URI[g77.md5sum] = "57d489658743f0d9048e440b312740c8"
SRC_URI[g77.sha256sum] = "3ea32832e07571be317cdb1f9b9dc678a51ad2c2f066f91e155c449d0cf7d796"
SRC_URI[java.md5sum] = "96b039f4e11bff4d3d8a4e7da6e3998d"
SRC_URI[java.sha256sum] = "ec7a963c0dfd986697350be26e53577b0a39c86970b4e9485d85ca99b0cb2197"
SRC_URI[objc.md5sum] = "2bffc1e314f2efb1034b3d3ea1ce2f7d"
SRC_URI[objc.sha256sum] = "a8a3c0f0a38f819b87ff9282f1e40536f5050153f0f60db5c869509a70497c2c"
SRC_URI[ada.md5sum] = "30154205636c12c6abcc462ce07550cf"
SRC_URI[ada.sha256sum] = "404358fe19326679f602de6f7d6a2db180e27af83813150f58ab28eec197b646"
