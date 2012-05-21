DESCRIPTION = "libmikmod is a module player library supporting many formats, including mod, s3m, it, and xm."
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPLv2.1"
PR = "r5"

SRC_URI = "\
  ${SOURCEFORGE_MIRROR}/mikmod/libmikmod-${PV}.tar.gz \
  file://m4.patch \
  file://autofoo.patch \
  file://ldflags.patch \
  file://CVE-2010-2971.patch \
"

inherit autotools binconfig

EXTRA_OECONF = "\
  --disable-af \
  --enable-alsa \
  --disable-esd \
  --enable-oss \
  --disable-sam9407 \
  --disable-ultra \
  --disable-esdtest \
  --enable-threads \
"


SRC_URI[md5sum] = "9f3c740298260d5f88981fc0d51f6f16"
SRC_URI[sha256sum] = "891a2b780306e6ef86e381f459e71a085d4e7f56c970a879d3bf341c01bdfc32"
