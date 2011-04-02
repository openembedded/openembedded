DESCRIPTION = "librs232 - library for serial communications over RS-232 (serial port)"
HOMEPAGE = "http://github.com/ynezz/librs232"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://COPYING;md5=814bfb5f5c804f9554bf9c8f5b09fb83"

SRC_URI = "git://github.com/ynezz/librs232.git;protocol=git"

SRCREV = "e9017b66f6bf259279bba7d1d00f39d6abb1c38a"
S = "${WORKDIR}/git/"

inherit autotools
