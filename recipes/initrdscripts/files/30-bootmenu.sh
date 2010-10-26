#
# (c) 2007 Paul Sokolovsky
#

# If root is explicitly specified, skip interactive selection
if [ -z "$ROOT_DEVICE" ]; then
##############################

E="\033["
MOUNTLOC="tmp"
LOOP_IMG_MASK='*.img'

if ! (echo " " | read -n1 foo) >/dev/null 2>&1; then
    echo "'read' command lacks -n switch support, aborting" 
    exit 1
fi

mkdir -p $MOUNTLOC

list=""

add_menu_item()
{
    if [ -n "$list" ]; then
	list="$list\n"
    fi
	
    list="$list$1"
}

show_menu() {
    echo -e -n "${E}3;0H" >$CONSOLE
    cnt=0
    echo -e $list | \
    while read l; do
        if [ $cnt = $num ]; then
	    echo -e -n "${E}1m" >$CONSOLE
	fi
        echo -e "$cnt: $l${E}0m" >$CONSOLE
	cnt=$((cnt + 1))
    done
}

get_menu_selection()
{
    cnt=0
    sel=`echo -e $list | \
    while read l; do
    if [ $cnt = $num ]; then
	    echo $l
	    break
	fi
	cnt=$((cnt + 1))
    done`
}

get_partition_type()
{
#    fstype=`mount -f --guess-fstype /dev/$dev $MOUNTLOC`
    fstype=`fstype </dev/$dev`
    fstype=`expr "$fstype" : 'FSTYPE=\([A-Za-z0-9]*\).*'`
}

scan_for_loopimgs()
{
# Scan a device for loopback images, add to the list if found
	mount /dev/$dev $MOUNTLOC
	p=$PWD
	cd $MOUNTLOC
	for img in `ls -1 $LOOP_IMG_MASK 2>/dev/null`; do
	    add_menu_item "$dev/$img (loop img on vfat)"
	done
	cd $p
	umount $MOUNTLOC
}

# Scan all available device/partitions
while read maj min nblk dev; do
    if [ -z "$maj" -o "$maj" = "major" ]; then
	continue;
    fi

    get_partition_type
    if [ "$fstype" != "ext2" -a "$fstype" != "ext3" -a "$fstype" != "vfat" -a "$fstype" != "jffs2" ]; then
	# Comment following line to show all available block devices regardless of FS (for debug purposes)
	continue
	true
    fi
    
    if [ "$fstype" = "vfat" ]; then
	scan_for_loopimgs
	continue
    fi
    
    add_menu_item "$dev ($fstype)"
done < /proc/partitions

add_menu_item "NFS (nfsroot=192.168.2.200:/srv/nfs/oe/image)"
add_menu_item "Shell"

total=`echo -e $list | wc -l`
num=0

# Draw UI
stty -F $CONSOLE -echo
echo -e -n "${E}2J" >$CONSOLE
echo -e -n "${E}0;0H" >$CONSOLE
echo "Select boot image:" >$CONSOLE

# Main loop
show_menu
while read -s -n1 i; do
    case "$i" in
	"A")
	    num=$((num - 1))
	    if [ $num -lt 0 ]; then
		num=$(($total - 1))
	    fi
	;;
	["B"-"Z"])
	    num=$((num + 1))
	    if [ $num -ge $total ]; then
		num=0
	    fi
	;;
	"q")
	    exec sh
	;;
	"")
	    break
	;;
    esac
    show_menu
#    echo "*$esc$i"
done < $CONSOLE

stty echo

# Process results of user selection, prepare input arguments
# for boot modules

get_menu_selection
echo Selected: $sel

dev=`expr "$sel" : '\([^ /]*\)'`
path=`expr "$sel" : '[^/]*\([^ ]*\).*'`
fstype=`expr "$sel" : '[^ ]* *\(.*\)'`

if [ "$dev" = "Shell" ]; then
    if [ -x /usr/sbin/dropbear ]; then
	modprobe g_ether
	ifconfig usb0 192.168.2.202
	mkdir -p /dev/pts
	mount -t devpts devpts /dev/pts
	export PATH=$PATH:/usr/sbin
	/usr/sbin/dropbear -E
	echo "Started dropbear @192.168.2.202"
    fi

    exec /bin/sh
elif [ "$dev" = "NFS" ]; then
    ROOT_DEVICE="/dev/nfs"
    CMDLINE="$CMDLINE root=/dev/nfs nfsroot=192.168.2.200:/srv/nfs/oe/image"
elif [ -n "$path" ]; then
    ROOT_DEVICE="/dev/loop"
    CMDLINE="$CMDLINE root=/dev/loop looproot=/dev/$dev:$path"
else
    ROOT_DEVICE="/dev/$dev"
    # jffs2 is not recognized by mount automagically
    if [ "$fstype" = "(jffs2)" ]; then
	ROOT_FSTYPE="jffs2"
    fi
    CMDLINE="$CMDLINE root=$ROOT_DEVICE"
fi

echo ROOT_DEVICE=$ROOT_DEVICE >$CONSOLE
echo CMDLINE=$CMDLINE >$CONSOLE

##############################
fi
