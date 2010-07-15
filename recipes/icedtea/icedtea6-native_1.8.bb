# Note: DO NOT USE THIS PACKAGE. While the build is fine, the resulting JDK
# is unable to compile itself yet (some issue with the built-in XML parser).
require ${PN}.inc

PR = "${INC_PR}.0"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "\
	http://icedtea.classpath.org/download/source/icedtea6-${PV}.tar.gz;name=iced \
	http://download.java.net/openjdk/jdk6/promoted/b18/openjdk-6-src-b18-16_feb_2010.tar.gz;subdir=openjdk-src-dir;name=ojdk \
        ${JAXWS_URI} \
        ${JAF_URI} \
        ${JAXP_URI} \
	file://disable-library-checks.patch \
	file://build-hacks-native.patch \
	file://icedtea-sane-x86-arch-name.patch \
	${ICEDTEA_PATCHES} \
	"
SRC_URI[ojdk.md5sum] = "94db01691ab38f98b7d42b2ebf4d5c0b"
SRC_URI[ojdk.sha256sum] = "778ea7b323aaa24d3c6e8fe32b8bb0f49040d9e86271859077ada9f9ee3c8ebf"
SRC_URI[iced.md5sum] = "e08dd0762749fb50ec6c273c366ee8ae"
SRC_URI[iced.sha256sum] = "6823ff87969d978fe5523c729be3074142698c89acc8cc96c05b849fde54f61b"

JAXWS_URI = "http://icedtea.classpath.org/download/source/drops/jdk6-jaxws-2009_10_27.zip;name=jaxws"
SRC_URI[jaxws.md5sum] = "3ea5728706169498b722b898a1008acf"
SRC_URI[jaxws.sha256sum] = "155ff3be83c980e197621a2fbf7ee34e8e0f536489351a5865cf0e52206245e2"

JAF_URI = "http://icedtea.classpath.org/download/source/drops/jdk6-jaf-2009_10_27.zip;name=jaf"
SRC_URI[jaf.md5sum] = "7a50bb540a27cdd0001885630088b758"
SRC_URI[jaf.sha256sum] = "fdc51476fc6bcc69ea1f099f33e84601a126bfa8b11c8fa11c25dc574345aa9f"

JAXP_URI = "https://jaxp.dev.java.net/files/nidaba/documents/913/147329/jdk6-jaxp-2009_10_13.zip;name=jaxp"
SRC_URI[jaxp.md5sum] = "a2f7b972124cd776ff71e7754eb9a429"
SRC_URI[jaxp.sha256sum] = "8714d55de18db48ca9da0ee986202005082f44cf4c215da8683342b70e61792b"


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

EXTRA_OECONF += " --with-jaxws-drop-zip=${DL_DIR}/jdk6-jaxws-2009_10_27.zip \
                  --with-jaf-drop-zip=${DL_DIR}/jdk6-jaf-2009_10_27.zip \
                  --with-jaxp-drop-zip=${DL_DIR}/jdk6-jaxp-2009_10_13.zip "
