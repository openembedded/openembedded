setenv vram '12M'
setenv defaultdisplay 'lcd43 mem=99M@0x80000000 mem=128M@0x88000000 omapfb.vram=0:8M,1:2M,2:2M' 
run loaduimage
run mmcboot
