mmcinit
fatload mmc 0 0x82000000 uImage
setenv bootargs 'console=tty1 omapfb.mode=dvi:1024x600MR-24@60 root=/dev/mmcblk0p2 rootwait rootfstype=ext3 mem=88M@0x80000000 mem=128M@0x88000000 vram=16M omapfb.vram=0:8M,1:4M,2:4M'
bootm
