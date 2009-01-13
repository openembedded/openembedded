squashfs_mount () {
	modprobe -q squashfs

	mkdir $2
	mount -t squashfs $1 $2
}

for arg in $CMDLINE; do
    optarg=`expr "x$arg" : 'x[^=]*=\(.*\)'`
    echo $arg xxx $optarg 
    case $arg in
        squashfs=*)
        dev=`expr "$optarg" : '\([^:]*\).*'`
        path=`expr "$optarg" : '[^:]*:\([^:]*\).*'`
        squashfs_mount $dev $path ;;
    esac
done
