PR = "${INC_PR}.0"

FILESPATHPKG =. "klibc-${PV}:"

do_install() {
       install -d ${D}${base_bindir}
       install -m 755 usr/dash/sh ${D}${base_bindir}
       install -m 755 usr/kinit/kinit ${D}${base_bindir}
}

# Package only separate utils
PACKAGES = ""

KLIBC_UTILS_VARIANT = "static"
KLIBC_UTILS_PKGNAME = "klibc-static-utils"

require klibc-utils.inc
require klibc.inc
require klibc-checksums_${PV}.inc
