# On xM: bootargs=console=ttyS2,115200n8 mem=80M@0x80000000 mem=384M@0x88000000 mpurate=1000 buddy=none camera=lbcm3m1 vram=16M omapfb.vram=0:8M,1:4M,2:4M omapfb.mode=dvi:hd720 omapdss.def_disp=dvi root=/dev/mmcblk0p2 rw rootfstype=ext3 rootwait
mmc init
setenv dvimode hd720
setenv vram 16M omapfb.vram=0:8M,1:4M,2:4M
if test "${beaglerev}" = "AxBx"; then
setenv optargs mem=80M@0x80000000 musb_hdrc.fifomode=5
elif test "${beaglerev}" = "Cx"; then
setenv optargs mem=80M@0x80000000 mem=128M@0x88000000 musb_hdrc.fifomode=5
else
setenv optargs mem=80M@0x80000000 mem=384M@0x88000000
fi
run loaduimage
run mmcboot

