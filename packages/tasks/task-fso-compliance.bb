DESCRIPTION = "The freesmartphone.org framework -- install this task to make your distribution FSO-compliant."
SECTION = "fso/base"
LICENSE = "MIT"
PV = "1.0"
PR = "r4"

inherit task

RDEPENDS_${PN} = "\
  dbus-hlid \
  frameworkd \
  fso-gpsd \
  connman \
"

RRECOMMENDS_${PN} = "\
  gsm0710muxd \
  wmiconfig \
  \
  tzdata \
  tzdata-americas \
  tzdata-asia \
  tzdata-europe \
"
