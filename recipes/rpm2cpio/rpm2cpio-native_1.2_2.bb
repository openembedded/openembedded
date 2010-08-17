# rpm2cpio-native build file
# Copyright (C) 2005, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see COPYING.MIT)
LICENSE = "BSD"
DEPENDS = "perl-native"
PR = "r1"

SRC_URI = "http://www.freebsd.org/cgi/cvsweb.cgi/%7Echeckout%7E/ports/archivers/rpm2cpio/files/rpm2cpio?rev=1.2"
SRC_URI[md5sum] = "07f64fa3dae6eb8b1b578d01473a5c07"
SRC_URI[sha256sum] = "a98cb1d9903192c4fcf40d82c705e091a5c193f87327703217749a5f4cc6197d"

S = "${WORKDIR}"

inherit native

do_compile() {
}
do_install() {
        install -d ${D}${bindir}
        sed -e '1,1s|${bindir}/|${bindir}/env |' "rpm2cpio?rev=1.2" \
                > ${D}${bindir}/rpm2cpio.pl
        my_PERL="/usr/bin/env perl"
        sed -e "s%/[a-zA-Z0-9/]*/bin/perl%$my_PERL%g" -i ${D}${bindir}/rpm2cpio.pl
        chmod 0755 ${D}${bindir}/rpm2cpio.pl
}

NATIVE_INSTALL_WORKS = "1"

