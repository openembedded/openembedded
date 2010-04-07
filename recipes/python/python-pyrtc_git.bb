DESCRIPTION = "PyRTC is a python extension module that supports talking to the \
RTC (Real Time Clock) found in most PCs and SOCs"
SECTION = "devel/python"
HOMEPAGE = "http://www.freesmartphone.org"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
LICENSE = "GPLv2"
SRCNAME = "pyrtc"
DEPENDS = "python-cython-native"
SRCREV = "${FSO_PYTHONHELPERS_SRCREV}"
PV = "1.0.0+gitr${SRCREV}"
PR = "ml1"

SRC_URI = "git://git.freesmartphone.org/python-helpers.git;protocol=git;branch=master"
S = "${WORKDIR}/git/${SRCNAME}"

inherit distutils

