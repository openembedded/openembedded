
mw.l 480bc050 0x0210
mw.l 480bc040 0x00200300

setenv vram '24M'
setenv dvimode 'hd720-16 mem=99M@0x80000000 mem=384M@0x88000000 omapfb.vram=0:12M,1:8M,2:4M'
run loaduimage
run mmcboot
