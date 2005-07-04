#! /bin/sh
case "$1" in
  start)
        echo -n "Unmounting virtual fs from initrd"
        umount /mnt/initfs/sys
        umount /mnt/initfs/proc
        ;;
  stop)
        ;;
  *)
        echo "Usage: $SCRIPTNAME {start|stop}" >&2
        exit 1
        ;;
esac

exit 0 
                                                                   