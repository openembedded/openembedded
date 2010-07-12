require openjdk-6-common.inc

EXTRA_OECONF += "\
	--with-jaxws-drop-zip=${DL_DIR}/jdk6-jaxws-2009_10_27.zip \ 
	--with-jaf-drop-zip=${DL_DIR}/jdk6-jaf-2009_10_27.zip \
	--with-jaxp-drop-zip=${DL_DIR}/jdk6-jaxp-2009_10_13.zip \
	--with-cacao-src-zip=${DL_DIR}/cacao-0.99.4.tar.gz \
"

# Use IcedTea6 1.8 release.
ICEDTEA = "icedtea6-1.8"
ICEDTEA_URI = "http://icedtea.classpath.org/download/source/${ICEDTEA}.tar.gz"

OPENJDK_URI = "http://download.java.net/openjdk/jdk6/promoted/b18/openjdk-6-src-b18-16_feb_2010.tar.gz;subdir=openjdk-src-dir"

JAXWS_URI = "http://kenai.com/projects/jdk6-drops/downloads/download/jdk6-jaxws-2009_10_27.zip"

JAF_URI = "http://kenai.com/projects/jdk6-drops/downloads/download/jdk6-jaf-2009_10_27.zip"

JAXP_URI = "https://jaxp.dev.java.net/files/nidaba/documents/913/147329/jdk6-jaxp-2009_10_13.zip"

CACAO_URI = "http://www.complang.tuwien.ac.at/cacaojvm/download/cacao-0.99.4/cacao-0.99.4.tar.gz"

# Allow overriding this separately
OEPATCHES = "\
	file://build-hacks.patch;patch=1 \
	file://zero-cmpswap-long.patch;patch=1 \
	file://fix_hotspot_crosscompile.patch;patch=1 \
	file://mkbc_returncode.patch;patch=1 \
	file://icedtea-fix-jar-command.patch;patch=1 \
	file://fix-llvm-libs.patch;patch=1 \
	file://shark-build-openjdkdir.patch;patch=1 \
	file://shark-arm-linux-cpu-detection.patch;patch=1 \
        file://icedtea1.8-pre1.8.1-releasebranch-fixes.patch;patch=1 \
	"

# Allow overriding this separately
ICEDTEAPATCHES = "\
	file://icedtea-launcher-stdc++.patch \
	file://icedtea-crosscompile-fix.patch \
	file://icedtea-hostbuildcc.patch \
	file://icedtea-unbreak-float.patch \
	file://icedtea-remove_werror.patch \
	file://cacao-vfp-compat.patch \
	file://cacao-disable-stackbase-check.patch \
        file://icedtea-libnet-renaming.patch \
	"

ICEDTEAPATCHES_append_linux-uclibc = " \
        file://icedtea-hotspot-isfinte.patch \
        file://icedtea-hotspot-glibc-version.patch \
        file://icedtea-hotspot-loadavg.patch \
        file://icedtea-hotspot-isnanf.patch \
        file://icedtea-jdk-iconv-uclibc.patch \
        file://icedtea-jdk-remove-unused-backtrace.patch \
        file://icedtea-jdk-RTLD_NOLOAD.patch \
        file://icedtea-jdk-unpack-uclibc.patch \
        "

ICEDTEAPATCHES_append_linux-uclibceabi = " \
        file://icedtea-hotspot-isfinte.patch \
        file://icedtea-hotspot-isnanf.patch \
        file://icedtea-hotspot-glibc-version.patch \
        file://icedtea-hotspot-loadavg.patch \
        file://icedtea-jdk-iconv-uclibc.patch \
        file://icedtea-jdk-remove-unused-backtrace.patch \
        file://icedtea-jdk-RTLD_NOLOAD.patch \
        file://icedtea-jdk-unpack-uclibc.patch \
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

DISTRIBUTION_PATCHES_append_linux-uclibc = "\
        patches/icedtea-hotspot-isfinte.patch \
        patches/icedtea-hotspot-isnanf.patch \
        patches/icedtea-hotspot-glibc-version.patch \
        patches/icedtea-hotspot-loadavg.patch \
        patches/icedtea-jdk-iconv-uclibc.patch \
        patches/icedtea-jdk-remove-unused-backtrace.patch \
        patches/icedtea-jdk-RTLD_NOLOAD.patch \
        patches/icedtea-jdk-unpack-uclibc.patch \
        "
DISTRIBUTION_PATCHES_append_linux-uclibceabi = "\
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
