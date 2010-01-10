EXTRA_OECONF = " \
  --enable-threads \
  --enable-ethernet \
  --enable-wifi \
  --enable-bluetooth \
  --enable-modemmgr \
  --enable-udhcp \
  --enable-dhclient \
  --enable-resolvconf \
  --enable-loopback \
  --enable-dnsproxy \
  --enable-novatel \
  --enable-huawei \
  --enable-hso \
  --enable-mbm \
  --enable-ppp \
  --disable-polkit \
  --enable-client \
  --enable-tools \
  --enable-fake \
"

EXTRA_OECONF_append_shr += "--disable-tools"

require connman.inc

SRCREV = "1a94db417ecaba20a609ff4b4431a3f67c5dcbc6" 

PV = "0.42+git"
PR = "r2"
PR_append = ".gitr${SRCREV}"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_angstrom = "1"

SRC_URI = "\
  git://git.kernel.org/pub/scm/network/connman/connman.git;protocol=git \
  file://connman \
"

S = "${WORKDIR}/git"
