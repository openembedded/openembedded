PR = "${INC_PR}.0"

require klibc.inc
DEPENDS = "klibc"

FILESPATHPKG =. "klibc-${PV}:"

export KLCC_INST=${STAGING_DIR_TARGET}/lib/klibc

inherit cross

do_install() {
         install -d ${D}${TOOLCHAIN_PATH}/bin/
         install -m 0755 klcc/klcc ${D}${TOOLCHAIN_PATH}/bin/${TARGET_PREFIX}klcc
}

PACKAGES = "${PN}"
FILES_${PN} = "${D}${TOOLCHAIN_PATH}/bin/${TARGET_PREFIX}klcc"

SRC_URI[md5sum] = "1b713fe65c345e687666b9f94b12f0a0"
SRC_URI[sha256sum] = "de0fa51d47b7363e064a3e6f26dabcb458d371a14e78e6407d49bb3386a24a97"
