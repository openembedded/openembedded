setenv vram '16M'
setenv dvimode 'hd720-16 mem=99M@0x80000000 mem=128M@0x88000000 omapfb.vram=0:8M,1:4M,2:4M'
run loaduimage
run mmcboot
