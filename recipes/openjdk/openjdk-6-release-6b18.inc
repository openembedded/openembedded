require openjdk-6-common.inc

EXTRA_OECONF += "\
	--with-jaxws-drop-zip=${DL_DIR}/jdk6-jaxws-2009_10_27.zip \ 
	--with-jaf-drop-zip=${DL_DIR}/jdk6-jaf-2009_10_27.zip \
	--with-jaxp-drop-zip=${DL_DIR}/jdk6-jaxp-2009_10_13.zip \
	--with-cacao-src-zip=${DL_DIR}/cacao-0.99.4.tar.gz \
"

# Force arm mode for now
ARM_INSTRUCTION_SET_armv4t = "ARM"

# Use IcedTea6 1.8 release.
ICEDTEA = "icedtea6-1.8.2"
ICEDTEA_URI = "http://icedtea.classpath.org/download/source/${ICEDTEA}.tar.gz;name=iced"

SRC_URI[iced.md5sum] = "e9559699e56e90a9d50ffae2020f5df7"
SRC_URI[iced.sha256sum] = "93d7f427fde99f2df7b457c811405af8311e0bce4192ff99516b3227d5daa716"

OPENJDK_URI = "http://download.java.net/openjdk/jdk6/promoted/b18/openjdk-6-src-b18-16_feb_2010.tar.gz;subdir=openjdk-src-dir;name=openjdk"
SRC_URI[openjdk.md5sum] = "94db01691ab38f98b7d42b2ebf4d5c0b"
SRC_URI[openjdk.sha256sum] = "778ea7b323aaa24d3c6e8fe32b8bb0f49040d9e86271859077ada9f9ee3c8ebf"

JAXWS_URI = "http://icedtea.classpath.org/download/source/drops/jdk6-jaxws-2009_10_27.zip;name=jaxws"
SRC_URI[jaxws.md5sum] = "3ea5728706169498b722b898a1008acf"
SRC_URI[jaxws.sha256sum] = "155ff3be83c980e197621a2fbf7ee34e8e0f536489351a5865cf0e52206245e2"

JAF_URI = "http://icedtea.classpath.org/download/source/drops/jdk6-jaf-2009_10_27.zip;name=jaf"
SRC_URI[jaf.md5sum] = "7a50bb540a27cdd0001885630088b758"
SRC_URI[jaf.sha256sum] = "fdc51476fc6bcc69ea1f099f33e84601a126bfa8b11c8fa11c25dc574345aa9f"

JAXP_URI = "https://icedtea.classpath.org/download/source/drops/jdk6-jaxp-2009_10_13.zip;name=jaxp"
SRC_URI[jaxp.md5sum] = "a2f7b972124cd776ff71e7754eb9a429"
SRC_URI[jaxp.sha256sum] = "8714d55de18db48ca9da0ee986202005082f44cf4c215da8683342b70e61792b"

CACAO_URI = "http://www.complang.tuwien.ac.at/cacaojvm/download/cacao-0.99.4/cacao-0.99.4.tar.gz;name=cacao"
SRC_URI[cacao.md5sum] = "c5e6525c5212ddbb6026e4a7cde37ca6"
SRC_URI[cacao.sha256sum] = "c6090c1d2ed3c60acda0076b62563598267be8dab270ce49ee1035002a2510cf"

# Allow overriding this separately
OEPATCHES = "\
	file://build-hacks.patch \
	file://zero-cmpswap-long.patch \
	file://fix_hotspot_crosscompile.patch \
	file://mkbc_returncode.patch \
	file://icedtea-fix-jar-command.patch \
	file://fix-llvm-libs.patch \
	file://shark-build-openjdkdir.patch \
	file://shark-arm-linux-cpu-detection.patch \
	"

# Allow overriding this separately
ICEDTEAPATCHES = "\
	file://icedtea-launcher-stdc++.patch;apply=no \
	file://icedtea-crosscompile-fix.patch;apply=no \
	file://icedtea-hostbuildcc.patch;apply=no \
	file://icedtea-unbreak-float.patch;apply=no \
	file://icedtea-remove_werror.patch;apply=no \
	file://cacao-vfp-compat.patch;apply=no \
	file://cacao-disable-stackbase-check.patch;apply=no \
        file://icedtea-libnet-renaming.patch;apply=no \
	"

ICEDTEAPATCHES_append_libc-uclibc = " \
        file://icedtea-hotspot-isfinte.patch;apply=no \
        file://icedtea-hotspot-glibc-version.patch;apply=no \
        file://icedtea-hotspot-loadavg.patch;apply=no \
        file://icedtea-hotspot-isnanf.patch;apply=no \
        file://icedtea-jdk-iconv-uclibc.patch;apply=no \
        file://icedtea-jdk-remove-unused-backtrace.patch;apply=no \
        file://icedtea-jdk-RTLD_NOLOAD.patch;apply=no \
        file://icedtea-jdk-unpack-uclibc.patch;apply=no \
        "

# Allow overriding this separately
DISTRIBUTION_PATCHES = "\
	patches/icedtea-launcher-stdc++.patch \
	patches/icedtea-crosscompile-fix.patch \
	patches/icedtea-hostbuildcc.patch \
	patches/icedtea-unbreak-float.patch \
	patches/icedtea-remove_werror.patch \
	patches/cacao-vfp-compat.patch \
	patches/cacao-disable-stackbase-check.patch \
        patches/icedtea-libnet-renaming.patch \
	"

DISTRIBUTION_PATCHES_append_libc-uclibc = "\
        patches/icedtea-hotspot-isfinte.patch \
        patches/icedtea-hotspot-isnanf.patch \
        patches/icedtea-hotspot-glibc-version.patch \
        patches/icedtea-hotspot-loadavg.patch \
        patches/icedtea-jdk-iconv-uclibc.patch \
        patches/icedtea-jdk-remove-unused-backtrace.patch \
        patches/icedtea-jdk-RTLD_NOLOAD.patch \
        patches/icedtea-jdk-unpack-uclibc.patch \
        "

export DISTRIBUTION_PATCHES
