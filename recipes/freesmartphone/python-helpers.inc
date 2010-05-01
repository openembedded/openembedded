HOMEPAGE = "http://www.freesmartphone.org"
SECTION = "console/network"
LICENSE = "GPLv2"
PE = "1"

FSO_PYTHONHELPERS_SRCREV ?= "63b1dff1bc8ac22efabcee8a90e957c3b2423317"
SRC_URI = "${FREESMARTPHONE_GIT}/python-helpers.git;protocol=git;branch=master"
S = "${WORKDIR}/git"
