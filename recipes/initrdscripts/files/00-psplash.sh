mkdir -p /mnt/.psplash
mount tmpfs -t tmpfs /mnt/.psplash -o,size=40k

psplash &
