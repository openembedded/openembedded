require directfb.inc

RV = "1.2-0"
PR = "r1"

DEPENDS += "sysfsutils"

SRC_URI = " \
    http://www.directfb.org/downloads/Old/DirectFB-${PV}.tar.gz \
    file://directfb-1.2.x-fix-pkgconfig-cflags.patch;patch=1 \
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

LDFLAGS_append = ""

LEAD_SONAME = "libdirectfb-1.2.so.0"

SRC_URI[md5sum] = "caea8bcfc9c1d391e56d85e437005a5d"
SRC_URI[sha256sum] = "0875e553a17fe65e920ad810a67aa6faca582c53476d8dc75880a6b3da625d0b"
