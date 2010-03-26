setenv vram '20M'
setenv dvimode 'hd720 mem=99M@0x80000000 mem=128M@0x88000000 omapfb.vram=0:12M,1:4M,2:4M'
run loaduimage
run mmcboot
