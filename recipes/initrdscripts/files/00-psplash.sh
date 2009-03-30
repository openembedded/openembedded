if ! grep -Eq '\s?psplash=false\s?' /proc/cmdline; then
	mkdir -p /mnt/.psplash
	mount tmpfs -t tmpfs /mnt/.psplash -o,size=40k

	psplash &
fi
