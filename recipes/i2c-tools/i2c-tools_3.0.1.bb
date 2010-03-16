DESCRIPTION = "Set of i2c tools for linux"
SECTION = "base"
LICENSE = "GPLv2"

SRC_URI = "http://dl.lm-sensors.org/i2c-tools/releases/i2c-tools-${PV}.tar.bz2"

inherit autotools

do_compile_prepend() {
        sed -i 's_/usr/local_/usr_' Makefile
        sed -i 's_CC\t:= gcc_CC\t:= ${CC}_' Makefile
}
