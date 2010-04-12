require connman.inc
PR = "r5"

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
  --enable-tools \
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
  file://link-against-libnl2.patch;patch=1 \
  file://no_system_user_perms.patch;patch=1 \
  file://connman \
"

SRC_URI[md5sum] = "9bcdc528f38bc17ecb92519a28b741f1"
SRC_URI[sha256sum] = "1853ed3d6400e25ef61ba1c98a7ef0f3984a2bf59aaf3485721cbc1de036b75c"
