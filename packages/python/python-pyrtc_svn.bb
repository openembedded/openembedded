DESCRIPTION = "PyRTC is a python extension module that supports talking to the \
RTC (Real Time Clock) found in most PCs and SOCs"
SECTION = "devel/python"
HOMEPAGE = "http://www.freesmartphone.org"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
LICENSE = "GPLv2"
SRCNAME = "pyrtc"
DEPENDS = "python-cython-native"
PV = "1.0.0+svnr${SRCREV}"
PR = "ml0"

SRC_URI = "svn://projects.linuxtogo.org/svn/smartphones/trunk/software;module=${SRCNAME}"
S = "${WORKDIR}/${SRCNAME}"

inherit distutils

