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

SRC_URI[md5sum] = "5c8b6577b9acb3809cace6e118cdd55b"
SRC_URI[sha256sum] = "e4104f8b34a5f354222bd4622f50b58c6218bf70614450d68539cbef666b6446"
