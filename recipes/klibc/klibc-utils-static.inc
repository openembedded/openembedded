FILESPATHPKG =. "klibc-${PV}:"

do_install() {
       install -d ${D}${base_bindir}
       install -m 755 usr/dash/sh ${D}${base_bindir}
       install -m 755 usr/kinit/kinit ${D}${base_bindir}
}

#Package only separate utils
PACKAGES = ""

KLIBC_UTILS_VARIANT = "static"
KLIBC_UTILS_PKGNAME = "klibc-utils-static"
require klibc-utils.inc
