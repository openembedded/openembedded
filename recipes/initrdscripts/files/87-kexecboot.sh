#!/bin/sh
# Allow kexecing to kernel in rootfs

if [ -n "$BOOT_ROOT" -a -f "$BOOT_ROOT/boot/zImage" ]; then
    if ! expr "$CMDLINE" : '.*nokexec'; then
	echo "Kernel found in rootfs:" >$CONSOLE
	ls -l "$BOOT_ROOT/boot/zImage" >$CONSOLE
	initramfs=""
	if [ -f "$BOOT_ROOT/boot/initramfs.bin" ]; then
	    echo "Initramfs found in rootfs:"
	    ls -l "$BOOT_ROOT/boot/initramfs.bin"
    	    initramfs="--initrd=$BOOT_ROOT/boot/initramfs.bin"
        fi
	echo /usr/sbin/kexec $initramfs --command-line="$CMDLINE nokexec" -f "$BOOT_ROOT/boot/zImage" >$CONSOLE
        sleep 10
	/usr/sbin/kexec $initramfs --command-line="$CMDLINE nokexec" -f "$BOOT_ROOT/boot/zImage"
        sleep 10000
    fi
fi
