#!/bin/sh
# set -x
# on debian-like systems
# set up bridge aptitude install bridge-utils
# 
# change /etc/network/interfaces to something like below and restart
# network

#auto lo
#iface lo inet loopback
#
#auto br0
#iface br0 inet static
#        address 10.0.1.37
#        netmask 255.255.0.0
#        gateway 10.0.0.1
#        bridge_ports eth0
#        bridge_maxwait 0
#        bridge_fd 9
#        bridge_stp off
#
#iface eth0 inet ipv4ll
#
#auto eth0

supported_archs="{arm mips x86}"
if [ $# -ne 1 ]; then
    echo -en "
    Usage: `basename $0` <arch>
    where <arch> is one $supported_archs
    Example: `basename $0` arm
"
    exit 1
fi

arch=$1
case $arch in
    arm)
	address="10.0.1.101"
        macaddr="00:16:3e:00:00:01"
	machine="versatilepb"
	gdbport="1234"
	consoleopt="console=ttyAMA0 console=ttyS0"
	rootdisk="sda"
	qemu="qemu-system-arm"
	libc="uclibc"
        kernel="/scratch/oe/deploy/$libc/images/qemu$arch/zImage-qemuarm.bin"
        hdimage="/scratch/oe/deploy/$libc/images/qemu$arch/native-sdk-image-qemuarm.ext2"
        #hdimage="/scratch/oe/deploy/$libc/images/qemu$arch/console-image-qemuarm.ext2"
        ;;
    mips)
	address="10.0.1.102"
        macaddr="00:16:3e:00:00:02"
	machine="malta"
	gdbport="1235"
        consoleopt="console=ttyS0"
	rootdisk="hda"
	qemu="qemu-system-mips"
	libc="uclibc"
        kernel="/scratch/oe/deploy/$libc/images/qemu$arch/vmlinux-qemumips.bin"
        hdimage="/scratch/oe/deploy/$libc/images/qemu$arch/native-sdk-image-qemumips.ext2"
        hdimage="/scratch/oe/deploy/$libc/images/qemu$arch/console-image-qemumips.ext2"
        ;;
    ppc|powerpc)
    	arch=ppc
	address="10.0.1.103"
        macaddr="00:16:3e:00:00:03"
	machine="bamboo"
	gdbport="1236"
        consoleopt="console=ttyS0"
	rootdisk="hdc" #hdc4
	qemu="qemu-system-ppcemb"
	libc="eglibc"
        kernel="/scratch/oe/deploy/$libc/images/qemu$arch/uImage-qemuppc.bin"
        hdimage="/scratch/oe/deploy/$libc/images/qemu$arch/helloworld-image-qemuppc.ext2"
        ;;
    sh|sh4)
    	arch=sh4
	address="10.0.1.104"
        macaddr="00:16:3e:00:00:04"
	machine="r2d"
	gdbport="1237"
        #consoleopt="console=tty0 console=ttySC1"
	rootdisk="sdc2" #hdc4
	qemu="qemu-system-sh4 -serial vc -serial stdio"
	#qemu="qemu-system-sh4"
	libc="uclibc"
        kernel="/scratch/oe/deploy/$libc/images/qemu$arch/zImage-qemush4.bin"
        #kernel="/home/kraj/qemu/sh/sh-test-0.2/zImage"
        hdimage="/scratch/oe/deploy/$libc/images/qemu$arch/console-image-qemush4.ext2"
        #hdimage="/home/kraj/qemu/sh/sh-test-0.2/sh-linux-mini.img"
        ;;
    x86)
	address="10.0.1.105"
        macaddr="00:16:3e:00:00:05"
	gdbport="1237"
	machine="pc"
        consoleopt="console=ttyS0"
	rootdisk="hda"
	qemu="qemu"
	libc="uclibc"
        kernel="/scratch/oe/deploy/$libc/images/qemu$arch/bzImage-qemux86.bin"
        hdimage="/scratch/oe/deploy/$libc/images/qemu$arch/native-sdk-image-qemux86.ext2"
        hdimage="/scratch/oe/deploy/$libc/images/qemu$arch/minimalist-image-qemux86.ext2"
        hdimage="/scratch/oe/deploy/$libc/images/qemu$arch/console-image-qemux86.ext2"
        ;;
    *)
        echo "Specify one architectures out of $supported_archs to emulate."
   	exit 1
    	;;
    esac

nfsserver="10.0.1.37"		# address of NFS server
gateway="10.0.0.1"		# default gateway
netmask="255.255.0.0"		# subnet mask
hostname="qemu$arch"		# hostname for guest server
nfsdir="/opt/oe/$hostname"	# nfs directory where root file system is
device="eth0"			# interface that guest server will use
mem=256				# memory for guest server in Mb
gdbit="-gdb tcp::$gdbport"	# debug the kernel using gdb set it to -s
				# add -S to stop after launch and wait for
				# gdb to connect

nfsopts="rsize=8192,wsize=8192,hard,intr,tcp,nolock"	# nfs options

# for NFS root 
rootfs="root=/dev/nfs rw nfsroot=$nfsserver:$nfsdir,$nfsopts"

# Boot from a Disk Image

rootfs="root=/dev/$rootdisk rw"

# ip format
#ip=<client-ip>:<server-ip>:<gw-ip>:<netmask>:<hostname>:<device>:<autoconf>
ipopt="ip=$address::$gateway:$netmask:$hostname:$device:off"

# get IP from DHCP server on network
#ipopt="ip=dhcp"

init=""
qemuifup="/home/kraj/work/oe/openembedded/contrib/qemu/qemu-ifup"
qemuifdown="/home/kraj/work/oe/openembedded/contrib/qemu/qemu-ifdown"

uid=`whoami`
iface=`sudo tunctl -b -u $uid`

netopt="-net nic,vlan=0,macaddr=$macaddr -net tap,vlan=0,ifname=$iface,script=$qemuifup,downscript=$qemuifdown"

if [ "x$1" == "xsingle" ]
then
    init="init=/bin/sh"
fi
echo "Starting QEMU ..."
set -x
	#-L /scratch/oe/deploy/$libc/images/qemu$arch \
$qemu -M $machine --snapshot $gdbit -m $mem -kernel $kernel -hda $hdimage \
	-usb -usbdevice wacom-tablet -nographic --no-reboot -localtime \
	-append "$consoleopt $rootfs $ipopt $init debug user_debug=-1" \
	$netopt
set +x
#destroy the tap interface
sudo tunctl -b -d $iface
stty sane
# qemu-system-sh4 -M r2d -kernel ~/zImage -nographic -monitor null -serial null -serial stdio  
