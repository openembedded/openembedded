do_install() {
        install -d ${D}${base_bindir}
        install -m 755 usr/dash/sh.${KLIBC_UTILS_VARIANT} ${D}${base_bindir}/sh
        install -m 755 usr/kinit/kinit.${KLIBC_UTILS_VARIANT} ${D}${base_bindir}/kinit

        install -d ${D}${base_libdir}
        install -m 755 usr/klibc/klibc-*.so ${D}${base_libdir}
        cd ${D}${base_libdir}
        ln -s klibc-*.so klibc.so
        cd -
}

export INST=${STAGING_DIR_TARGET}
do_stage() {
        oe_runmake  install
        cp '${STAGING_DIR_TARGET}/bin/klcc'  '${STAGING_DIR_NATIVE}${prefix_native}/bin/${TARGET_PREFIX}klcc'
}

PACKAGES = "${PN} ${PN}-dev "
FILES_${PN} = "${base_libdir}/klibc-*.so"
FILES_${PN}-dev = "${base_libdir}/klibc.so"

require klibc-utils.inc

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
RDEPENDS_${KLIBC_UTILS_PKGNAME}-minips = "${PN} (=${PV}-${PR})"
RDEPENDS_${KLIBC_UTILS_PKGNAME}-mkdir = "${PN} (=${PV}-${PR})"
RDEPENDS_${KLIBC_UTILS_PKGNAME}-mkfifo = "${PN} (=${PV}-${PR})"
RDEPENDS_${KLIBC_UTILS_PKGNAME}-mknod = "${PN} (=${PV}-${PR})"
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
RDEPENDS_${KLIBC_UTILS_PKGNAME}-modprobe = "${PN} (=${PV}-${PR})"
RDEPENDS_${KLIBC_UTILS_PKGNAME}-losetup = "${PN} (=${PV}-${PR})"
RDEPENDS_${KLIBC_UTILS_PKGNAME}-wc = "${PN} (=${PV}-${PR})"
RDEPENDS_${KLIBC_UTILS_PKGNAME}-ls = "${PN} (=${PV}-${PR})"
