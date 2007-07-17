#!/bin/sh

echo "Starting initramfs boot..."
mkdir /proc
mount -t proc proc /proc

for arg in `cat /proc/cmdline`; do
    echo $arg
    optarg=`expr "x$arg" : 'x[^=]*=\(.*\)'`
    echo $optarg
    case $arg in
        root=*)
            root=$optarg ;;
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

case "x$device" in
    usb*)
	echo "USB"
	modprobe g_ether
	;;
esac

ifconfig $device $client_ip
)

mkdir /mnt
if [ "x$root" = "x/dev/nfs" ]; then
    echo "booting from NFS: $nfsroot"
    mount -t nfs $nfsroot /mnt
else
    echo "booting from: $root"
    mount $root /mnt
fi

cd /mnt
exec switch_root -c /dev/console /mnt /sbin/init
