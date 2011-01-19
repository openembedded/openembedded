PR = "${INC_PR}.2"

require klibc.inc
require klibc-checksums_${PV}.inc

SRC_URI += "file://klcc_prefix.patch \
            file://use-env-for-perl.patch"

DEPENDS = "klibc"

FILESPATHPKG =. "klibc-${PV}:"

export KLCC_INST=${STAGING_DIR_TARGET}/lib/klibc

inherit cross

do_install() {
         install -d ${D}${TOOLCHAIN_PATH}/bin/
         install -m 0755 klcc/klcc ${D}${TOOLCHAIN_PATH}/bin/${TARGET_PREFIX}klcc
}

PACKAGES = "${PN}"
FILES_${PN} = "${TOOLCHAIN_PATH}/bin/${TARGET_PREFIX}klcc"
