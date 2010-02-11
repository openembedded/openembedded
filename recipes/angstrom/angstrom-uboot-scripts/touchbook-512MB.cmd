mmcinit
fatload mmc 0 0x82000000 uImage
setenv bootargs 'console=tty1 omapfb.mode=dvi:1024x600MR-24@60 root=/dev/mmcblk0p2 rootwait rootfstype=ext3 mem=99M@0x80000000 mem=384M@0x88000000 vram=32M omapfb.vram=0:16M,1:8M,2:8M'
bootm
