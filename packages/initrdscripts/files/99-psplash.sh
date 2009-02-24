if ! grep -Eq '\s?psplash=false\s?' /proc/cmdline; then
	mkdir -p /mnt/mnt/.psplash
	mount -n -o move /mnt/.psplash /mnt/mnt/.psplash
fi
