ext3_mount () {
	modprobe -q ext3

	mkdir -p $2
	mount -t ext3 -onoatime,data=journal,errors=continue $1 $2
}

for arg in $CMDLINE; do
    optarg=`expr "x$arg" : 'x[^=]*=\(.*\)'`
    echo $arg xxx $optarg 
    case $arg in
        ext3=*)
        dev=`expr "$optarg" : '\([^:]*\).*'`
        path=`expr "$optarg" : '[^:]*:\([^:]*\).*'`
        ext3_mount $dev $path ;;
    esac
done
