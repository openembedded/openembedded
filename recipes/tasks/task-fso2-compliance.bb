DESCRIPTION = "The freesmartphone.org Framework 2.0. \
Install this task to make your distribution FSO 2.0-compliant."
SECTION = "fso/base"
LICENSE = "MIT"
PV = "1.9.0"
PR = "r0"

inherit task

RDEPENDS_${PN} = "\
  dbus-hlid \
  libfsoframework \
  libfsotransport \
  \
  fsodeviced \
  fsonetworkd \
  fsousaged \
  \
  fso-apmd \
  fso-gpsd \
  fso-monitord \
  connman \
  connman-scripts \
  connman-plugin-bluetooth \
#  connman-plugin-dhclient \
#  connman-plugin-dnsproxy \
#  connman-plugin-ethernet \
#  connman-plugin-fake \
  connman-plugin-loopback \
  connman-plugin-pppd \
#  connman-plugin-resolvconf \
  connman-plugin-udhcp \
  connman-plugin-wifi \
  connman-test-utils \
"

RRECOMMENDS_${PN} = "\
  fso-abyss \
  wmiconfig \
  \
  tzdata \
  tzdata-americas \
  tzdata-asia \
  tzdata-europe \
"
