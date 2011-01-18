DESCRIPTION = "libmikmod is a module player library supporting many formats, including mod, s3m, it, and xm."
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "LGPL"

PR = "r3"

DEFAULT_PREFERENCE = "-1"

TARGET_CC_ARCH += "${LDFLAGS}"

SRC_URI = "\
  http://mikmod.raphnet.net/files/libmikmod-${PV}.tar.gz \
  file://m4.patch \
  file://autofoo.patch \
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
  LIBRARY_LIB=-lm \
"
SRC_URI[md5sum] = "19fc0879aebd1610813a23bd84726362"
SRC_URI[sha256sum] = "857b66ef04d695f70414188b985e08b04f1f62cc250d72a43d0e0609dfbdba03"
