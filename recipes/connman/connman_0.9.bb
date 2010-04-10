require connman.inc
PR = "r4"

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


SRC_URI[md5sum] = "a5ebd17ff19e8f9b4d5e783d345d135b"
SRC_URI[sha256sum] = "9c626bda7e2cc460cdbfe9a14c13208253de6922a341ef60ba51a673c0317996"
