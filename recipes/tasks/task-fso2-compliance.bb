DESCRIPTION = "The freesmartphone.org Framework 2.0. \
Install this task to make your distribution FSO 2.0-compliant."
SECTION = "fso/base"
LICENSE = "MIT"
PV = "1.9.0"
PR = "r6"

inherit task

RDEPENDS_${PN} = "\
  dbus-hlid \
  \
  libfsobasics \
  libfsotransport \
  libfsoframework \
  libfsoresource \
  \
  fsodatad \
  fsodeviced \
  fsogsmd \
  fsotdld \
#  fsomusicd \
  fsonetworkd \
  fsousaged \
  \
# included in fsodeviced now
#  fso-alsa-data \
  fso-apm \
  fso-gpsd \
#  fso-monitord \
#  connman \
#  connman-scripts \
#  connman-plugin-bluetooth \
#  connman-plugin-dhclient \
#  connman-plugin-dnsproxy \
#  connman-plugin-ethernet \
#  connman-plugin-fake \
#  connman-plugin-loopback \
#  connman-plugin-pppd \
#  connman-plugin-resolvconf \
#  connman-plugin-udhcp \
#  connman-plugin-wifi \
#  connman-test-utils \
"

RRECOMMENDS_${PN} = "\
#  fso-abyss \
  wmiconfig \
  tzdata \
  tzdata-africa \
  tzdata-americas \
  tzdata-asia \
  tzdata-australia \
  tzdata-europe \
"
