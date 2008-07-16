require cacao.inc

PR = "r0"

SRC_URI = "http://www.complang.tuwien.ac.at/cacaojvm/download/cacao-${PV}/cacao-${PV}.tar.bz2;md5sum=912e353a26c88ba5f5f59ebb9f688e2f \
          "

# Quirks for Nokia N800:
# - with mfloat-abi=softfp the runtime fails to run anything
# - without --enable-softfloat it cannot find files within Jars
TARGET_CC_ARCH_nokia800 = "-march=armv6j -mtune=arm1136jf-s -mfpu=vfp -mfloat-abi=soft"

EXTRA_OECONF_append_nokia800 = "--enable-softfloat"
