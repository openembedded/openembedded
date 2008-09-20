require directfb.inc

RV = "1.2-0"
PR = "r0"

DEPENDS += "sysfsutils"

SRC_URI = " \
    http://www.directfb.org/downloads/Old/DirectFB-${PV}.tar.gz \
    file://fix-pkgconfig-cflags.patch;patch=1 \
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
