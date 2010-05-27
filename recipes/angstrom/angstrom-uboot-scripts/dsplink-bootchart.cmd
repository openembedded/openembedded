setenv vram '20M'
setenv dvimode 'hd720 mem=99M@0x80000000 mem=128M@0x88000000 omapfb.vram=0:12M,1:4M,2:4M'
run loaduimage
echo Booting from mmc ...
setenv bootargs init=/sbin/bootchartd quiet initcall_debug console=${console} mpurate=${mpurate} vram=${vram} omapfb.mode=dvi:${dvimode} omapdss.def_disp=${defaultdisplay} root=${mmcroot} rootfstype=${mmcrootfstype}
bootm ${loadaddr}
