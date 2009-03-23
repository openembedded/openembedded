#!/bin/sh

if [ "$ROOT_DEVICE" = "/dev/nfs" ]; then

    # These correspond to what kernel itself uses
    # DO NOT CHANGE!
    NFS_OPTIONS="-o nfsvers=2,nolock"

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
	sleep 5
    	;;
    esac
    
    ifconfig $device $client_ip
    ping -c 2 $server_ip
    )

    echo "booting from NFS: $nfsroot"
    mount -t nfs $NFS_OPTIONS $nfsroot /mnt
    BOOT_ROOT=/mnt
fi
