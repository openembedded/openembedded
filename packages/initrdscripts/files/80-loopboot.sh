#!/bin/sh

if [ "$ROOT_DEVICE" = "/dev/loop" ]; then
    loop_mount() {
        loopdev=/dev/loop$loop_num
        mountpt=/mnt/loop$loop_num

        [ -e $loopdev ] || mknod $loopdev b 7 $loop_num

        # if only one argument was specified, let it be path not dev
        if [ -z "$path" ] && [ -n "$dev" ]; then
            path="$dev"
            dev=""
        fi
        [ -z "$offset" ] && offset=0
     
        if [ -n "$dev" ]; then
            hostpt=`expr "$dev" : '.*/\([^/]*\)'`
            [ -z "$hostpt" ] && hostpt="$dev"
            
            echo "Mounting $dev on $hostpt"
            mkdir $hostpt
            mount $dev $hostpt
        fi
    
        echo "Loopback setup of $path (offset $offset)"
        losetup -o "$offset" "$loopdev" "$hostpt/$path"

        echo "Mounting $loopdev on $mountpt"
        mkdir "$mountpt"
        mount "$loopdev" "$mountpt"
        cd "$mountpt"
        BOOT_ROOT="$mountpt"
        loop_num=`expr "$loop_num" + 1`
    }

    modprobe loop
    
    loop_num=0
    
    for arg in $CMDLINE; do
        optarg=`expr "x$arg" : 'x[^=]*=\(.*\)'`
        echo $arg xxx $optarg 
        case $arg in
            looproot=*)
                dev=`expr "$optarg" : '\([^:]*\).*'`
                path=`expr "$optarg" : '[^:]*:\([^:]*\).*'`
                offset=`expr "$optarg" : '[^:]*:[^:]*:\([^:]*\).*'`
                loop_mount ;;
        esac
    done
fi 
