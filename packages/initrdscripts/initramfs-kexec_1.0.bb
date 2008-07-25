DESCRIPTON = "A init script that mounts a device and kexecs a new kernel from it."
PR = "r5"

do_compile() {
        cat > init.sh << EOF
#!/bin/sh
/bin/mount -t proc proc /proc
/bin/mount -t ${ROOTFS} ${ROOTDEV} /mnt
/usr/sbin/kexec -l /mnt/zImage
/usr/sbin/kexec -e
EOF
}

do_install() {
        install -m 0755 ${S}/init.sh ${D}/init
        install -d ${D}/proc
        install -d ${D}/mnt
}

PACKAGE_ARCH = "all"

FILES_${PN} = "/init /proc /mnt"

ROOTDEV = "/dev/mmcblk0p1"
ROOTFS = "ext2"
