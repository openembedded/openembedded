require ../freesmartphone/python-helpers.inc

DESCRIPTION = "PyRTC is a python extension module that supports talking to the \
RTC (Real Time Clock) found in most PCs and SOCs"
SECTION = "devel/python"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
LICENSE = "GPLv2"
SRCNAME = "pyrtc"
DEPENDS = "python-cython-native"
SRCREV = "${FSO_PYTHONHELPERS_SRCREV}"
PV = "1.0.0+gitr${SRCPV}"
PR = "ml1"

S = "${WORKDIR}/git/${SRCNAME}"

inherit distutils

