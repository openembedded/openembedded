require klibc_1.5.15+1.5.16.inc
PR = "r0"
DEFAULT_PREFERENCE = "-1"

KLIBC_FETCHDIR = "Testing"

# temporary override here in the recipe
# until 1.5.16 is released
SRC_URI = "${KERNELORG_MIRROR}/pub/linux/libs/klibc/${KLIBC_FETCHDIR}/klibc-1.5.15.tar.bz2 \
        file://fstype-sane-vfat-and-jffs2-for-1.5.patch;patch=1 \
        file://modprobe.patch;patch=1 \
        file://losetup.patch;patch=1 \
        file://dash_readopt.patch;patch=1 \
        file://wc.patch;patch=1 \
        "

# temporary taken from the inc
# until 1.5.16 is released
SRC_URI += " \
        file://fix-must_inline-macro-for-gcc4.3.patch;patch=1 \
        file://ipconfig-omit-zero-lenght-DHCP-vendor-class-id.patch;patch=1 \
        file://ipconfig-send-req-hostname-in-DHCP.patch;patch=1 \
        file://ipconfig-set-null-ciaddr-on-dhcprequest.patch;patch=1 \
        file://use-headers_install-to-install-headers.patch;patch=1 \
        file://klibc-utils-add-simple-ls.patch;patch=1 \
        file://staging.patch;patch=1 \
        file://klibc_kexecsyscall.patch;patch=1 \
        file://mntproc-definitions.patch;patch=1 \
        file://signal-cleanup.patch;patch=1 \
        file://isystem.patch;patch=1 \
        "

S = "${WORKDIR}/klibc-1.5.15"
