setenv console ttyO2,115200n8
setenv vram '16M'
setenv dvimode 'hd720 omapfb.vram=0:8M,1:4M,2:4M'
run loaduimage
run mmcboot
