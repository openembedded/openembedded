DESCRIPTION = "A GSM 07.10 Multiplexing Engine"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
LICENSE = "GPL"
SECTION = "devel"
DEPENDS = "glib-2.0 libgsm0710 libfsotransport"
SRCREV  = "4d7edda0efec7836612c8c64bb1b90695ca07a53"
PV = "0.9.2+gitr${SRCREV}"
PR = "r0"

SRC_URI = "${FREESMARTPHONE_GIT}/cornucopia.git;protocol=git;branch=master"
S = "${WORKDIR}/git/libgsm0710mux"

inherit autotools_stage pkgconfig vala
