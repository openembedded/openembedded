DESCRIPTON = "A init script that mounts a device and kexecs a new kernel from it."
PR = "r8"
RDEPENDS = "kexecboot klibc-utils-static-mount klibc-utils-static-sh klibc-utils-static-sleep"

FBANGLE = "270"
FBANGLE_c7x0 = "0"
INPUTDEV = "/dev/event0"


do_compile() {
        cat > init.sh << EOF
#!/bin/sh
/bin/sleep 3
/bin/mount -t proc proc /proc
echo "0 4 1 7" > /proc/sys/kernel/printk
/usr/bin/kexecboot -a ${FBANGLE} -i ${INPUTDEV}
EOF
}

do_install() {
        install -m 0755 ${S}/init.sh ${D}/init
        install -d ${D}/proc
        install -d ${D}/mnt
}

PACKAGE_ARCH = "all"

FILES_${PN} = "/init /proc /mnt"
