require ${PN}.inc

PR = "${INC_PR}.0"

SRC_URI = "\
	http://icedtea.classpath.org/download/source/icedtea6-${PV}.tar.gz;name=iced \
	http://download.java.net/openjdk/jdk6/promoted/b17/openjdk-6-src-b17-14_oct_2009.tar.gz;subdir=openjdk-src-dir;name=ojdk \
	file://disable-library-checks.patch \
	file://icedtea-fix-jar-path.patch \
	file://build-hacks-native.patch \
	file://icedtea-sane-x86-arch-name.patch \
        file://icedtea-javac-in.patch \
	${ICEDTEA_PATCHES} \
	"
SRC_URI[ojdk.md5sum] = "078fe0ab744c98694decc77f2456c560"
SRC_URI[ojdk.sha256sum] = "2019a4c3d2d14620caa78d7df49fd987a041066b4631bde4fd8424033f3c1785"
SRC_URI[iced.md5sum] = "0d61041e46253d089f1b30114716012d"
SRC_URI[iced.sha256sum] = "dbca9d7598352d178651c8cc28ff887c59a27f0125785a58e9f9723611137f78"

ICEDTEA_PATCHES = "\
	file://icedtea-ecj-disable-compilation.patch;apply=no \
	file://icedtea-ecj-fix-freetype.patch;apply=no \
	file://icedtea-ecj-fix-zlib.patch;apply=no \
	file://icedtea-hotspot-make-arch-sane-for-x86.patch;apply=no \
	file://icedtea-jdk-sane-x86-arch.patch;apply=no \
	file://icedtea-unbreak-float.patch;apply=no \
	"

export DISTRIBUTION_PATCHES = "\
	patches/icedtea-ecj-disable-compilation.patch \
	patches/icedtea-ecj-fix-freetype.patch \
	patches/icedtea-ecj-fix-zlib.patch \
	patches/icedtea-hotspot-make-arch-sane-for-x86.patch \
	patches/icedtea-jdk-sane-x86-arch.patch \
	patches/icedtea-unbreak-float.patch \
	"
