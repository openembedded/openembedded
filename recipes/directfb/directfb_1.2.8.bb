require directfb.inc

RV = "1.2-0"

DEPENDS += "sysfsutils"

SRC_URI = " \
    http://directfb.org/downloads/Core/DirectFB-1.2/DirectFB-${PV}.tar.gz \
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

SRC_URI[md5sum] = "ac13d21682aa368df4e177ae5b51ad2d"
SRC_URI[sha256sum] = "cbf94eb10e9c305c81b24e298e55c7825df5ab9060d82443f7b9734f760f859d"
