setenv vram '4M'
setenv dvimode 'hd720'
run loaduimage
echo Booting from mmc ...
setenv bootargs init=/bin/busybox sh console=${console} mpurate=${mpurate} vram=${vram} omapfb.mode=dvi:${dvimode} omapdss.def_disp=${defaultdisplay} root=${mmcroot} rootfstype=${mmcrootfstype}
bootm ${loadaddr}
