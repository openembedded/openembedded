require directfb.inc

RV = "1.2-0"
PR = "r0"

DEPENDS += "sysfsutils"

SRC_URI = " \
    http://directfb.org/downloads/Old/DirectFB-${PV}.tar.gz \
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

SRC_URI[md5sum] = "59ca16f600e96c8c104a485ff7c322c6"
SRC_URI[sha256sum] = "80ab8e34246a280bc380020cf331bcc0014cf816380cee3935ad455c108e661e"
