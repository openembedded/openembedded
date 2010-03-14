DESCRIPTION = "A demo phone application based on FSO"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
HOMEPAGE = "http://www.freesmartphone.org"
SECTION = "x11"
LICENSE = "GPLv2"
DEPENDS = "edje-native vala-native evas ecore edje libeflvala libfsobasics libfsoframework libfso-glib"
PV = "2.0.0+gitr${SRCREV}"
PR = "r0"

SRC_URI = "${FREESMARTPHONE_GIT}/aurora.git;protocol=git;branch=master"
S = "${WORKDIR}/git/zhone2"

inherit autotools_stage
