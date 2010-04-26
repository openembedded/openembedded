DESCRIPTION = "mioctl calls ioctls via command line interface"
HOMEPAGE = "http://www.freesmartphone.org"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
SECTION = "console"
LICENSE = "GPL"
SRCREV = "851245ec1e6a44b7e4939c8c8f5755aca62c9cdb"
PV = "0.1.0+gitr${SRCREV}"
PR = "r0"

SRC_URI = "${FREESMARTPHONE_GIT}/cornucopia.git;protocol=git;branch=master"
S = "${WORKDIR}/git/tools/mioctl"

do_stage() {
	:
}

inherit autotools vala
