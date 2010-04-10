require connman.inc
PR = "r0"

EXTRA_OECONF += "\
  --disable-gtk-doc \
  --enable-debug \
  --enable-threads \
  --enable-loopback \
  --enable-ethernet \
  --enable-wifi \
  --disable-wimax \
  --enable-bluetooth \
  --enable-udhcp \
  --enable-dhclient \
  --enable-resolvconf \
  --enable-dnsproxy \
  --disable-novatel \
  --disable-huawei \
  --disable-hso \
  --enable-ppp \
# needs udev >= 129
  --disable-udev \
  --disable-polkit \
  --enable-client \
  --enable-fake \
#  --with-udhcpc=PROGRAM \
#  --with-dhclient=PROGRAM \
#  --with-resolvconf=PROGRAM \
#  --with-pppd=PROGRAM \
"

SRC_URI  = "\
  http://www.kernel.org/pub/linux/network/connman/connman-${PV}.tar.gz \
  file://connman \
"


SRC_URI[md5sum] = "c0d27961dbdcb92b79dfde9c532dd348"
SRC_URI[sha256sum] = "2dda1ba0d18e2b6de5fddd33a18324c8e75cddfc7df61595babfc19931fa4507"
