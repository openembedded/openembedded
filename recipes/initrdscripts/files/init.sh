#!/bin/sh

MODULE_DIR=/initrd.d
BOOT_ROOT=
ROOT_DEVICE=

early_setup() {
    mkdir -p /proc /sys /mnt /tmp

    mount -t proc proc /proc
    mount -t sysfs sysfs /sys

    modprobe -q mtdblock
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
    [ -z "$CMDLINE" ] && CMDLINE=`cat /proc/cmdline`
    for arg in $CMDLINE; do
        optarg=`expr "x$arg" : 'x[^=]*=\(.*\)'`
        case $arg in
            root=*)
                ROOT_DEVICE=$optarg ;;
            rootfstype=*)
                ROOT_FSTYPE=$optarg ;;
            rootdelay=*)
                rootdelay=$optarg ;;
            debug) set -x ;;
            shell) sh ;;
        esac
    done
}

do_depmod() {
	[ -e "/lib/modules/$(uname -r)/modules.dep" ] || depmod
}

load_module() {
    # Cannot redir to $CONSOLE here easily - may not be set yet
    echo "initramfs: Loading $module module"
    source $1
}

load_modules() {
    for module in $MODULE_DIR/$1; do
        [ -e "$module"  ] && load_module $module
    done
}

boot_root() {
    cd $BOOT_ROOT
    exec switch_root -c /dev/console $BOOT_ROOT /sbin/init
}

fatal() {
    echo $1 >$CONSOLE
    echo >$CONSOLE
    exec sh
}


echo "Starting initramfs boot..."
early_setup
load_modules '0*'
do_depmod

[ -z "$CONSOLE" ] && CONSOLE="/dev/console"

read_args

if [ -z "$rootdelay" ]; then
    echo "rootdelay parameter was not passed on kernel command line - assuming 2s delay"
    echo "If you would like to avoid this delay, pass explicit rootdelay=0"
    rootdelay="2"
fi
if [ -n "$rootdelay" ]; then
    echo "Waiting $rootdelay seconds for devices to settle..." >$CONSOLE
    sleep $rootdelay
fi

dev_setup

load_modules '[1-9]*'

[ -n "$BOOT_ROOT" ] && boot_root

fatal "No valid root device was specified.  Please add root=/dev/something to the kernel command-line and try again."
