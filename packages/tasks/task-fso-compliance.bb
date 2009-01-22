DESCRIPTION = "The freesmartphone.org framework -- install this task to make your distribution FSO-compliant."
SECTION = "fso/base"
LICENSE = "MIT"
PV = "1.0"
PR = "r5"

inherit task

RDEPENDS_${PN} = "\
  dbus-hlid \
  frameworkd \
#  fso-apmd \
  fso-gpsd \
#  fso-monitord \
#  connman \
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
