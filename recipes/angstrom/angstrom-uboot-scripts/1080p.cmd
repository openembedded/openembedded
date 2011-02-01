setenv console 'tty0'
setenv vram '32M'
setenv dvimode '1920x1080MR-16@24 mem=99M@0x80000000 mem=384M@0x88000000 omapfb.vram=0:20M,1:8M,2:4M'
run loaduimage
run mmcboot
