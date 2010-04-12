require connman.inc

PR = "r1"

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


SRC_URI[md5sum] = "3d61c5db55d225c3efbf4c950dc0842f"
SRC_URI[sha256sum] = "cc4a4b73d8d7b0e19dd2dd274ba91acb67b14c84fc448a921d1359e25e4d2df0"
