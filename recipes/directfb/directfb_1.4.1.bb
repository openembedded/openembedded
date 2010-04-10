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

SRC_URI[md5sum] = "e7df079ff44ec98187c24a00500e597a"
SRC_URI[sha256sum] = "aa9d532ec4481a3c9f7b3298b1786a84825a3474b714690b901d0617743d8221"
