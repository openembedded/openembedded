require openjdk-6-common.inc

# needed for dis-asm.h
# if shark is needed
# DEPENDS += "binutils"

SRC_URI += "${JAMVM_URI}"

EXTRA_OECONF += "\
        --with-jdk-home=${WORKDIR}/fake-jdk \
	--with-jar=${STAGING_LIBDIR_JVM_NATIVE}/icedtea6-native/bin/jar \
	--with-out-rhino \
	--with-jaxws-drop-zip=${DL_DIR}/${JAXWS_FILE} \ 
	--with-jaf-drop-zip=${DL_DIR}/${JAF_FILE} \
	--with-jaxp-drop-zip=${DL_DIR}/${JAXP_FILE} \
	--with-cacao-src-zip=${DL_DIR}/${CACAO_VERSION}.tar.gz \
	--with-jamvm-src-zip=${DL_DIR}/jamvm-${JAMVM_VERSION}.tar.gz \
	--with-openjdk-src-zip=${DL_DIR}/openjdk-6-src-${OPENJDK_VERSION}-${OPENJDK_DATE}.tar.gz \
"

# List of additional JVM to include in the build.
WITH_ADDITIONAL_VMS = "cacao,jamvm"

# Name of the directory containing the compiled output
BUILD_DIR = "openjdk.build"
BUILD_DIR_ECJ = "openjdk.build-ecj"

# Force arm mode for now
ARM_INSTRUCTION_SET_armv4t = "ARM"

ICEDTEA_URI = "http://icedtea.classpath.org/download/source/${ICEDTEA}.tar.gz;name=iced"

OPENJDK_VERSION = "b24"
OPENJDK_DATE = "14_nov_2011"
OPENJDK_URI = "http://download.java.net/openjdk/jdk6/promoted/${OPENJDK_VERSION}/openjdk-6-src-${OPENJDK_VERSION}-${OPENJDK_DATE}.tar.gz;subdir=openjdk-src-dir;name=openjdk"
SRC_URI[openjdk.md5sum] = "0eabdd360169144336e50081b8d01001"
SRC_URI[openjdk.sha256sum] = "f84e7f0938f4939660ff8f9c2aa164d301faa8a519f2324ceb05ad34b2e09227"

JAXWS_FILE = "jdk6-jaxws2_1_6-2011_06_13.zip"
JAXWS_URI = "http://icedtea.classpath.org/download/drops/${JAXWS_FILE};name=jaxws"
SRC_URI[jaxws.md5sum] = "8fd91b09b643a19a912b8a75e7a7a9d5"
SRC_URI[jaxws.sha256sum] = "229040544e791f44906e8e7b6f6faf503c730a5d854275135f3925490d5c3be3"

JAF_FILE = "jdk6-jaf-b20.zip"
JAF_URI = "http://icedtea.classpath.org/download/drops/${JAF_FILE};name=jaf"
SRC_URI[jaf.md5sum] = "bc95c133620bd68c161cac9891592901"
SRC_URI[jaf.sha256sum] = "78c7b5c9d6271e88ee46abadd018a61f1e9645f8936cc8df1617e5f4f5074012"

JAXP_FILE = "jaxp144_03.zip"
JAXP_URI = "http://icedtea.classpath.org/download/drops/${JAXP_FILE};name=jaxp"
SRC_URI[jaxp.md5sum] = "9eea471ad474040265c688858fcf09aa"
SRC_URI[jaxp.sha256sum] = "c1a5348e17b330a7e4b18431e61a40efd2ba99a7da71102cf2c604478ef96012"

CACAO_URI = "http://icedtea.classpath.org/download/drops/cacao/${CACAO_VERSION}.tar.gz;name=cacao"

JAMVM_URI = "http://icedtea.classpath.org/download/drops/jamvm/jamvm-${JAMVM_VERSION}.tar.gz;name=jamvm"

# Allow overriding this separately
OEPATCHES = "\
	file://build-hacks.patch \
	file://cacao-libtoolize.patch \
	file://cacao-loadavg-makefile.patch \
	file://fix_hotspot_crosscompile.patch \
	file://cacao-loadavg.patch;apply=no \
	"

# Allow overriding this separately
ICEDTEAPATCHES = "\
	file://icedtea-launcher-stdc++.patch;apply=no \
	file://icedtea-crosscompile-fix.patch;apply=no \
	file://icedtea-hostbuildcc.patch;apply=no \
	file://icedtea-unbreak-float.patch;apply=no \
	file://icedtea-remove_werror.patch;apply=no \
        file://icedtea-libnet-renaming.patch;apply=no \
	file://icedtea-fix-xrender.patch;apply=no \
	file://icedtea-shark-arm-linux-cpu-detection.patch;apply=no \
        file://icedtea-zero-hotspotfix.patch;apply=no \
	"

ICEDTEAPATCHES_append_libc-uclibc = " \
        file://icedtea-hotspot-isfinte.patch;apply=no \
        file://icedtea-hotspot-glibc-version.patch;apply=no \
        file://icedtea-hotspot-loadavg.patch;apply=no \
        file://icedtea-hotspot-isnanf.patch;apply=no \
        file://icedtea-jdk-iconv-uclibc.patch;apply=no \
        file://icedtea-jdk-remove-unused-backtrace.patch;apply=no \
        file://icedtea-jdk-unpack-uclibc.patch;apply=no \
	file://icedtea-hotspot-dlvsym-uclibc.patch;apply=no \
        "

# Allow overriding this separately
DISTRIBUTION_PATCHES = "\
	patches/icedtea-launcher-stdc++.patch \
	patches/icedtea-crosscompile-fix.patch \
	patches/icedtea-hostbuildcc.patch \
	patches/icedtea-unbreak-float.patch \
	patches/icedtea-remove_werror.patch \
        patches/icedtea-libnet-renaming.patch \
	patches/icedtea-fix-xrender.patch \
	patches/icedtea-shark-arm-linux-cpu-detection.patch \
	patches/icedtea-zero-hotspotfix.patch \
	"

DISTRIBUTION_PATCHES_append_libc-uclibc = "\
        patches/icedtea-hotspot-isfinte.patch \
        patches/icedtea-hotspot-isnanf.patch \
        patches/icedtea-hotspot-glibc-version.patch \
        patches/icedtea-hotspot-loadavg.patch \
        patches/icedtea-jdk-iconv-uclibc.patch \
        patches/icedtea-jdk-remove-unused-backtrace.patch \
        patches/icedtea-jdk-unpack-uclibc.patch \
	patches/icedtea-hotspot-dlvsym-uclibc.patch \
        "

export DISTRIBUTION_PATCHES
