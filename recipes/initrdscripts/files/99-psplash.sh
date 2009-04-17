if ! grep -Eq '\s?psplash=false\s?' /proc/cmdline; then
	mkdir -p /mnt/mnt/.s0plash
	mount -n -o move /mnt/.splash /mnt/mnt/.splash
fi
