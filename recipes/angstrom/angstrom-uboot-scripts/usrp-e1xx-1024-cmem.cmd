setenv console 'ttyO2,115200n8'
setenv vram '16M mem=99M@0x80000000 mem=384M@0x88000000'
setenv dvimode '1024x768MR-24@60 omapfb.vram=0:8M,1:4M,2:4M'
run loaduimage
run mmcboot
