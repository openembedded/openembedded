require directfb.inc

RV = "1.1-0"
PR = "r0"

DEPENDS += "sysfsutils"

DEFAULT_PREFERENCE = "-1"

SRC_URI = " \
    http://www.directfb.org/downloads/Old/DirectFB-${PV}.tar.gz \
    file://fix-pkgconfig-cflags.patch;patch=1 \
    file://fix-font-missing-char.patch;patch=1 \
    file://mkdfiff.patch;patch=1 \
    file://dont-use-linux-config.patch;patch=1 \
    file://ts_lib_autotools.patch;patch=1 \
"

EXTRA_OECONF = "\
  --enable-freetype=yes \
  --enable-zlib \
  --with-gfxdrivers=none \
  --disable-libmpeg3 \
  --disable-sdl \
  --disable-vnc \
  --disable-x11 \
"

SRC_URI[md5sum] = "c75255049ca8d5c69afe4db58f603028"
SRC_URI[sha256sum] = "f12ec5f0864d85268a8d67e4919cb7f3d7f0e06ed6cc278c952f6c342673d931"
