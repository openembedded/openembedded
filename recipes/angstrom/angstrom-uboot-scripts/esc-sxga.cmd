setenv bootargs 'console=tty0 console=ttyS2,115200n8 mpurate=1000 nohz=off vram=16M omapfb.mode=dvi:1280x1024MR-24@60 omapdss.def_disp=dvi omapfb.vram=0:8M,1:4M,2:4M root=/dev/mmcblk0p2 rw rootfstype=ext3 rootwait mem=99M@0x80000000 mem=384M@0x88000000'
fatload mmc 0 0x82000000 uImage
bootm 0x82000000
EOF
