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
    echo -e -n "${E}3;0H"
    cnt=0
    echo -e $list | \
    while read l; do
        if [ $cnt == $num ]; then
	    echo -e -n "${E}1m"
	fi
        echo -e "$cnt: $l${E}0m"
	cnt=$((cnt + 1))
    done
}

get_menu_selection()
{
    cnt=0
    sel=`echo -e $list | \
    while read l; do
    if [ $cnt == $num ]; then
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
    if [ -z "$maj" -o "$maj" == "major" ]; then
	continue;
    fi

    get_partition_type
    if [ "$fstype" != "ext2" -a "$fstype" != "ext3" -a "$fstype" != "vfat" ]; then
#	continue
	true
    fi
    
    if [ "$fstype" == "vfat" ]; then
	scan_for_loopimgs
	continue
    fi
    
    add_menu_item "$dev ($fstype)"
done < /proc/partitions

add_menu_item "NFS (nfsroot=192.168.2.200:/srv/nfs/oe/image)"

total=`echo -e $list | wc -l`
num=0

# Draw UI
stty -echo
echo -e -n "${E}2J"
echo -e -n "${E}0;0H"
echo "Select boot image:"

# Main loop
show_menu
while read -n1 i; do
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
done

stty echo

# Process results of user selection, prepare input arguments
# for boot modules

get_menu_selection
echo Selected: $sel

dev=`expr "$sel" : '\([^ /]*\)'`
path=`expr "$sel" : '[^/]*\([^ ]*\).*'`

if [ "$dev" == "NFS" ]; then
    ROOT_DEVICE="/dev/nfs"
    CMDLINE="$CMDLINE nfsroot=192.168.2.200:/srv/nfs/oe/image"
elif [ -n "$path" ]; then
    ROOT_DEVICE="/dev/loop"
    CMDLINE="looproot=/dev/$dev:$path"
else
    ROOT_DEVICE="/dev/$dev"
fi

echo ROOT_DEVICE=$ROOT_DEVICE
echo CMDLINE=$CMDLINE

##############################
fi
