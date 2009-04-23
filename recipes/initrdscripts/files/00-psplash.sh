if ! grep -Eq '\s?psplash=false\s?' /proc/cmdline; then
	mkdir -p /mnt/.splash
	mount tmpfs -t tmpfs /mnt/.splash -o,size=40k

	psplash &
fi
