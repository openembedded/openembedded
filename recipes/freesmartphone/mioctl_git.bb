DESCRIPTION = "mioctl calls ioctls via command line interface"
HOMEPAGE = "http://www.freesmartphone.org"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
SECTION = "console"
LICENSE = "GPL"
SRCREV = "43fae6cf5e3aa57f5d7fed467896d2d4d0f69679"
PV = "0.1.0+gitr${SRCPV}"
PE = "1"
DEPENDS = "glib-2.0"

SRC_URI = "${FREESMARTPHONE_GIT}/cornucopia.git;protocol=git;branch=master"
S = "${WORKDIR}/git/tools/mioctl"

inherit autotools vala
