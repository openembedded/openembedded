require cacao.inc

PR = "r9"

SRC_URI = "\
        http://jalimo.evolvis.org/repository/sources/cacao-${PV}.tar.bz2;md5sum=9ff10c929bd0cbf15909107c1aff7518 \
        file://cacao-0.98+svn-classpath_var.patch;patch=1 \
        file://cacao-0.98+hg-arm-cacheflush-fix.patch;patch=1 \
        file://cacao-0.98+hg-attachthread.patch;patch=1 \
        "

EXTRA_OECONF += "\
    --enable-annotations \
		"

# Quirks for Nokia N800:
# - with mfloat-abi=softfp the runtime fails to run anything
# - without --enable-softfloat it cannot find files within Jars
TARGET_CC_ARCH_nokia800 = "-march=armv6j -mtune=arm1136jf-s -mfpu=vfp -mfloat-abi=soft"

EXTRA_OECONF_append_nokia800 = "--enable-softfloat"
