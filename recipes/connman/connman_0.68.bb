require connman.inc
# connman requires libXtables now
DEPENDS += "iptables"
PR = "r2"

EXTRA_OECONF += "\
  --disable-gtk-doc \
  --enable-debug \
  --enable-threads \
  --enable-loopback \
  --enable-ethernet \
  --enable-wifi \
  --disable-wimax \
  --enable-bluetooth \
  --enable-ofono \
  --enable-resolvconf \
  --enable-dnsproxy \
  --enable-tools \
  --disable-polkit \
  --enable-client \
  --enable-fake \
"

SRC_URI  = "\
  http://www.kernel.org/pub/linux/network/connman/connman-${PV}.tar.gz \
  file://link-against-libnl2.patch \
  file://connman \
"

SRC_URI[md5sum] = "cff9fd78384a2660fb3b1d03128bb06c"
SRC_URI[sha256sum] = "b64254b74d6ceadb5525b84510135dbdf9166d806c6dacf5e44ec2d2836500d3"
