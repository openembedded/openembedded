FILESPATHPKG =. "klibc-${PV}:"

do_install() {
       install -d ${D}${base_bindir}
       install -m 755 usr/dash/sh ${D}${base_bindir}
       install -m 755 usr/kinit/kinit ${D}${base_bindir}
}

# Package only separate utils
PACKAGES = ""

KLIBC_UTILS_VARIANT = "static"
KLIBC_UTILS_PKGNAME = "klibc-utils-static"

#######################
require klibc-utils.inc
require klibc.inc

SRC_URI[md5sum] = "1b713fe65c345e687666b9f94b12f0a0"
SRC_URI[sha256sum] = "de0fa51d47b7363e064a3e6f26dabcb458d371a14e78e6407d49bb3386a24a97"
