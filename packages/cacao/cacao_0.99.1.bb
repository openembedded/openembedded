require cacao.inc

PR = "r0"

SRC_URI = "http://www.complang.tuwien.ac.at/cacaojvm/download/cacao-${PV}/cacao-${PV}.tar.bz2;md5sum=a5641452c7ba173060c99ed700950b3d \
           file://cacao-${PV}-build-java-runtime-library-classes.patch;patch=1 \
          "

# Quirks for Nokia N800:
# - with mfloat-abi=softfp the runtime fails to run anything
# - without --enable-softfloat it cannot find files within Jars
TARGET_CC_ARCH_nokia800 = "-march=armv6j -mtune=arm1136jf-s -mfpu=vfp -mfloat-abi=soft"

EXTRA_OECONF_append_nokia800 = "--enable-softfloat"
