DESCRIPTION = "The freesmartphone.org Framework 2.0. \
Install this task to make your distribution FSO 2.0-compliant."
SECTION = "fso/base"
LICENSE = "MIT"
PV = "1.9.0"
PR = "r10"

inherit task

RDEPENDS_${PN} = "\
  libfsobasics \
  libfsotransport \
  libfsoframework \
  libfsoresource \
  \
  fsodatad \
  fsodeviced \
  fsogsmd \
  fsotdld \
  fsonetworkd \
  fsousaged \
  fsoaudiod \
  \
  fso-apm \
  connman \
  connman-scripts \
  connman-plugin-bluetooth \
  connman-plugin-ethernet \
  connman-plugin-fake \
  connman-plugin-loopback \
  connman-plugin-wifi \
"

RRECOMMENDS_${PN} = "\
  wmiconfig \
  tzdata \
  tzdata-africa \
  tzdata-americas \
  tzdata-asia \
  tzdata-australia \
  tzdata-europe \
"
