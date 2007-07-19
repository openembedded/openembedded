#!/bin/sh

if [ "$ROOT_DEVICE" = "/dev/nfs" ]; then
    for arg in $CMDLINE; do
        echo $arg
        optarg=`expr "x$arg" : 'x[^=]*=\(.*\)'`
        echo $optarg
        case $arg in
            nfsroot=*)
                nfsroot=$optarg ;;
            ip=*)
                ip=$optarg ;;
        esac
    done
    
    echo $ip | (IFS=: read client_ip server_ip gw_ip netmask hostname device autoconf; \
    echo client_ip=$client_ip;
    echo server_ip=$server_ip;
    echo gw_ip=$gw_ip;
    echo netmask=$netmask;
    echo hostname=$hostname;
    echo device=$device;
    echo autoconf=$autoconf;
    
    case "$device" in
        usb*)
    	echo "USB"
    	modprobe g_ether
    	;;
    esac
    
    ifconfig $device $client_ip
    )

    echo "booting from NFS: $nfsroot"
    mount -t nfs $nfsroot /mnt
    BOOT_ROOT=/mnt
fi
