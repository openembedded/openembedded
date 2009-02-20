aufs_mount () {
	modprobe -q aufs

	mkdir -p $2 /mnt
	mount -t aufs -o br:$1:$2 none /mnt
}

for arg in $CMDLINE; do
    optarg=`expr "x$arg" : 'x[^=]*=\(.*\)'`
    case $arg in
        aufs=*)
        rw=`expr "$optarg" : '\([^:]*\).*'`
        ro=`expr "$optarg" : '[^:]*:\([^:]*\).*'`
        aufs_mount $rw $ro 
		BOOT_ROOT=/mnt ;;
    esac
done
