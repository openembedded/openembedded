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
<<<<<<< HEAD:packages/connman/connman_0.10.bb
  ftp://ftp.moblin.org/connman/releases/connman-${PV}.tar.gz \
=======
  http://www.kernel.org/pub/linux/network/connman/connman-${PV}.tar.gz \
>>>>>>> 82e5731... connman: Moved from moblin.org to kernel.org:packages/connman/connman_0.10.bb
  file://connman \
"

