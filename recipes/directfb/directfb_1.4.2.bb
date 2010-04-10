require directfb.inc

RV = "1.4-0"

DEPENDS += "sysfsutils"

SRC_URI = " \
    http://directfb.org/downloads/Core/DirectFB-1.4/DirectFB-${PV}.tar.gz \
    file://directfb-1.2.x-fix-pkgconfig-cflags.patch;patch=1 \
    file://mkdfiff.patch;patch=1 \
    file://dont-use-linux-config.patch;patch=1 \
    file://ts_lib_autotools.patch;patch=1 \
"

EXTRA_OECONF = "\
  --enable-freetype=yes \
  --enable-zlib \
  --with-gfxdrivers=none \
  --disable-sdl \
  --disable-vnc \
  --disable-x11 \
"

LDFLAGS_append = ""

LEAD_SONAME = "libdirectfb-1.4.so.0"

SRC_URI[md5sum] = "e4376c6c5b8e27d735edb7f62a7a8e86"
SRC_URI[sha256sum] = "051847e21e88a9c32ee78f8920014602d8b21928602075c5266433cd58addbc6"
