DESCRIPTION = "librs232 - library for serial communications over RS-232 (serial port)"
HOMEPAGE = "http://github.com/ynezz/librs232"
LICENSE = "MIT"

SRC_URI = "git://github.com/ynezz/librs232.git;protocol=git"

SRCREV = "ecad1e03104bc9bf348e0c5e571660f270c86421"
S = "${WORKDIR}/git/"

inherit autotools
