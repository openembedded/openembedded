setenv vram '24M'
setenv dvimode '1024x768MR-24@60 mem=99M@0x80000000 mem=384M@0x88000000 omapfb.vram=0:12M,1:8M,2:4M'
run loaduimage
run mmcboot
