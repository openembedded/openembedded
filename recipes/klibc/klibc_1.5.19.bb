PR = "${INC_PR}.0"

export INST=${D}
export KLCC_INST=${STAGING_DIR_TARGET}/lib/klibc

do_install() {
        oe_runmake install
        install -d ${D}${base_bindir}
        install -m 755 usr/dash/sh.${KLIBC_UTILS_VARIANT} ${D}${base_bindir}/sh
        install -m 755 usr/kinit/kinit.${KLIBC_UTILS_VARIANT} ${D}${base_bindir}/kinit

        install -d ${D}${base_libdir}
        install -m 755 usr/klibc/klibc-*.so ${D}${base_libdir}
        (cd  ${D}${base_libdir}; ln -s klibc-*.so klibc.so)
        install -m 755 klcc/klcc ${TOOLCHAIN_PATH}/bin/${TARGET_PREFIX}klcc
}

PACKAGES = "${PN} ${PN}-dev "
FILES_${PN} = "${base_libdir}/klibc-*.so"
FILES_${PN}-dev = "${base_libdir}/klibc.so"

# Yes we want exactly the klibc that was compiled with the utils
RDEPENDS_${KLIBC_UTILS_PKGNAME}-sh = "${PN} (=${PV}-${PR})"
RDEPENDS_${KLIBC_UTILS_PKGNAME}-kinit = "${PN} (=${PV}-${PR})"
RDEPENDS_${KLIBC_UTILS_PKGNAME}-fstype = "${PN} (=${PV}-${PR})"
RDEPENDS_${KLIBC_UTILS_PKGNAME}-ipconfig = "${PN} (=${PV}-${PR})"
RDEPENDS_${KLIBC_UTILS_PKGNAME}-nfsmount = "${PN} (=${PV}-${PR})"
RDEPENDS_${KLIBC_UTILS_PKGNAME}-resume = "${PN} (=${PV}-${PR})"
RDEPENDS_${KLIBC_UTILS_PKGNAME}-run-init = "${PN} (=${PV}-${PR})"
RDEPENDS_${KLIBC_UTILS_PKGNAME}-cat = "${PN} (=${PV}-${PR})"
RDEPENDS_${KLIBC_UTILS_PKGNAME}-chroot = "${PN} (=${PV}-${PR})"
RDEPENDS_${KLIBC_UTILS_PKGNAME}-cpio = "${PN} (=${PV}-${PR})"
RDEPENDS_${KLIBC_UTILS_PKGNAME}-dd = "${PN} (=${PV}-${PR})"
RDEPENDS_${KLIBC_UTILS_PKGNAME}-dmesg = "${PN} (=${PV}-${PR})"
RDEPENDS_${KLIBC_UTILS_PKGNAME}-false = "${PN} (=${PV}-${PR})"
RDEPENDS_${KLIBC_UTILS_PKGNAME}-halt = "${PN} (=${PV}-${PR})"
RDEPENDS_${KLIBC_UTILS_PKGNAME}-insmod = "${PN} (=${PV}-${PR})"
RDEPENDS_${KLIBC_UTILS_PKGNAME}-kill = "${PN} (=${PV}-${PR})"
RDEPENDS_${KLIBC_UTILS_PKGNAME}-ln = "${PN} (=${PV}-${PR})"
RDEPENDS_${KLIBC_UTILS_PKGNAME}-losetup = "${PN} (=${PV}-${PR})"
RDEPENDS_${KLIBC_UTILS_PKGNAME}-ls = "${PN} (=${PV}-${PR})"
RDEPENDS_${KLIBC_UTILS_PKGNAME}-minips = "${PN} (=${PV}-${PR})"
RDEPENDS_${KLIBC_UTILS_PKGNAME}-mkdir = "${PN} (=${PV}-${PR})"
RDEPENDS_${KLIBC_UTILS_PKGNAME}-mkfifo = "${PN} (=${PV}-${PR})"
RDEPENDS_${KLIBC_UTILS_PKGNAME}-mknod = "${PN} (=${PV}-${PR})"
RDEPENDS_${KLIBC_UTILS_PKGNAME}-modprobe = "${PN} (=${PV}-${PR})"
RDEPENDS_${KLIBC_UTILS_PKGNAME}-mount = "${PN} (=${PV}-${PR})"
RDEPENDS_${KLIBC_UTILS_PKGNAME}-nuke = "${PN} (=${PV}-${PR})"
RDEPENDS_${KLIBC_UTILS_PKGNAME}-pivot-root = "${PN} (=${PV}-${PR})"
RDEPENDS_${KLIBC_UTILS_PKGNAME}-poweroff = "${PN} (=${PV}-${PR})"
RDEPENDS_${KLIBC_UTILS_PKGNAME}-readlink = "${PN} (=${PV}-${PR})"
RDEPENDS_${KLIBC_UTILS_PKGNAME}-reboot = "${PN} (=${PV}-${PR})"
RDEPENDS_${KLIBC_UTILS_PKGNAME}-sleep = "${PN} (=${PV}-${PR})"
RDEPENDS_${KLIBC_UTILS_PKGNAME}-sync = "${PN} (=${PV}-${PR})"
RDEPENDS_${KLIBC_UTILS_PKGNAME}-true = "${PN} (=${PV}-${PR})"
RDEPENDS_${KLIBC_UTILS_PKGNAME}-umount = "${PN} (=${PV}-${PR})"
RDEPENDS_${KLIBC_UTILS_PKGNAME}-uname = "${PN} (=${PV}-${PR})"
RDEPENDS_${KLIBC_UTILS_PKGNAME}-wc = "${PN} (=${PV}-${PR})"

#######################
require klibc-utils.inc
require klibc.inc

SRC_URI[md5sum] = "1b713fe65c345e687666b9f94b12f0a0"
SRC_URI[sha256sum] = "de0fa51d47b7363e064a3e6f26dabcb458d371a14e78e6407d49bb3386a24a97"
