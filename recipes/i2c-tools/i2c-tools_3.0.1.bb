DESCRIPTION = "Set of i2c tools for linux"
SECTION = "base"
LICENSE = "GPLv2"

SRC_URI = "http://dl.lm-sensors.org/i2c-tools/releases/i2c-tools-${PV}.tar.bz2"

inherit autotools

do_compile_prepend() {
        sed -i 's#/usr/local#/usr#' Makefile
        sed -i 's#CC\t:= gcc#CC\t:= ${CC}#' Makefile
}

SRC_URI[md5sum] = "0f5c7ce5fd3c65113909db0ef3a3a8c8"
SRC_URI[sha256sum] = "8cf39f7c447b0b8f7a24eaed243ad4d8c654c2e94a146a796dba9ed08e857209"
