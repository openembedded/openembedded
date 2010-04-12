DESCRIPTION = "Set of i2c tools for linux"
SECTION = "base"
LICENSE = "GPLv2"

PR = "r1"

SRC_URI = "http://dl.lm-sensors.org/i2c-tools/releases/i2c-tools-${PV}.tar.bz2 \
           file://Module.mk \
          "

inherit autotools

do_compile_prepend() {
        cp ${WORKDIR}/Module.mk ${S}/eepromer/
        sed -i 's_/usr/local_/usr_' Makefile
        sed -i 's_CC\t:= gcc_CC\t:= ${CC}_' Makefile
        echo "include eepromer/Module.mk" >> Makefile
}

SRC_URI[md5sum] = "b546345ac19db56719dea6b8199f11e0"
SRC_URI[sha256sum] = "0b4d6455a30a3264a60b4d3be55855d996d52ea4f162a2f04ffff378e24f98a2"
