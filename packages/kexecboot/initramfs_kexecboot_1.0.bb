DESCRIPTON = "A init script that mounts a device and kexecs a new kernel from it."
PR = "r6"
RDEPENDS = "kexecboot"
do_compile() {
        cat > init.sh << EOF
#!/bin/sh
/bin/mount -t proc proc /proc
/usr/bin/kexecboot -a 270 -i /dev/event0
EOF
}

do_install() {
        install -m 0755 ${S}/init.sh ${D}/init
        install -d ${D}/proc
        install -d ${D}/mnt
}

PACKAGE_ARCH = "all"

FILES_${PN} = "/init /proc /mnt"
