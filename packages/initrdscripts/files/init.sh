#!/bin/sh

MODULE_DIR=/initrd.d
BOOT_ROOT=
ROOT_DEVICE=

early_setup() {
    mkdir /proc
    mount -t proc proc /proc
    mkdir /mnt
}

dev_setup()
{
    echo -n "initramfs: Creating device nodes: "
    grep '^ *[0-9]' /proc/partitions | while read major minor blocks dev
    do
        if [ ! -e /dev/$dev ]; then
            echo -n "$dev "
            [ -e /dev/$dev ] || mknod /dev/$dev b $major $minor
        fi
    done
    echo
}

read_args() {
    CMDLINE=`cat /proc/cmdline`
    for arg in $CMDLINE; do
        optarg=`expr "x$arg" : 'x[^=]*=\(.*\)'`
        case $arg in
            root=*)
                ROOT_DEVICE=$optarg ;;
            rootdelay=*)
                rootdelay=$optarg ;;
        esac
    done
}

load_modules() {
    for module in $MODULE_DIR/*; do
        echo "initramfs: Loading $module module"
        source $module
    done
}

boot_root() {
    cd $BOOT_ROOT
    exec switch_root -c /dev/console $BOOT_ROOT /sbin/init
}

boot_failed() {
    echo "No valid root device was specified.  Please add root=/dev/something to"
    echo "the kernel command-line and try again."
    echo
    exec sh
}

echo "Starting initramfs boot..."
early_setup
read_args

if [ -n "$rootdelay" ]; then
    echo "Waiting $rootdelay seconds for devices to settle..."
    sleep $rootdelay
fi

dev_setup

load_modules
[ -n "$BOOT_ROOT" ] && boot_root
boot_failed
