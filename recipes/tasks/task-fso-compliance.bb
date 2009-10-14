DESCRIPTION = "The freesmartphone.org framework -- install this task to make your distribution FSO-compliant."
SECTION = "fso/base"
LICENSE = "MIT"
PV = "1.0"
PR = "r8"

inherit task

RDEPENDS_${PN} = "\
  dbus-hlid \
  frameworkd \
#  fso-apmd \
  fso-gpsd \
#  fso-monitord \
  connman \
  connman-scripts \
#  connman-plugin-bluetooth \
#  connman-plugin-dhclient \
#  connman-plugin-dnsproxy \
#  connman-plugin-ethernet \
#  connman-plugin-fake \
#  connman-plugin-loopback \
#  connman-plugin-pppd \
#  connman-plugin-resolvconf \
  connman-plugin-udhcp \
  connman-plugin-wifi \
"

RRECOMMENDS_${PN} = "\
  fso-gsm0710muxd \
  wmiconfig \
  \
  tzdata \
  tzdata-americas \
  tzdata-asia \
  tzdata-europe \
"
