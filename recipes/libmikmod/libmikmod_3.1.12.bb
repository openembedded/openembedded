DESCRIPTION = "libmikmod is a module player library supporting many formats, including mod, s3m, it, and xm."
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"
PR = "r3"

SRC_URI = "\
  ${SOURCEFORGE_MIRROR}/mikmod/libmikmod-${PV}.tar.gz \
  file://m4.patch;patch=1 \
  file://autofoo.patch;patch=1 \
  file://ldflags.patch;patch=1 \
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

