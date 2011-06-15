PR = "${INC_PR}.0"

export INST=${D}

do_install() {

        oe_runmake install

# the crosscompiler is packaged by klcc-cross
# remove klcc
# remove also from FILES_${PN}-dev
        rm ${D}${base_bindir}/klcc

        # remove Linux headers .install and ..install.cmd files
        find ${D}${base_libdir}/klibc/include -name '.install' -delete
        find ${D}${base_libdir}/klibc/include -name '..install.cmd' -delete

        install -d ${D}${base_bindir}
        install -m 755 usr/dash/sh.${KLIBC_UTILS_VARIANT} ${D}${base_bindir}/sh
        install -m 755 usr/kinit/kinit.${KLIBC_UTILS_VARIANT} ${D}${base_bindir}/kinit

        install -d ${D}${base_libdir}
        install -m 755 usr/klibc/klibc-*.so ${D}${base_libdir}
        (cd  ${D}${base_libdir}; ln -s klibc-*.so klibc.so)

}

PACKAGES = "libklibc libklibc-dev"
FILES_libklibc = "${base_libdir}/klibc-*.so"
FILES_libklibc-dev = "${base_libdir}/klibc.so \
                   ${base_libdir}/klibc/lib/* \
                   ${base_libdir}/klibc/include/* \
# see above
# do not package it
#                   ${base_bindir}/klcc \
                  "

# Yes we want exactly the klibc that was compiled with the utils
THIS_KLIBC = "libklibc (= ${PV}-${PR})"

require klibc-utils.inc
require klibc.inc
require klibc-checksums_${PV}.inc
