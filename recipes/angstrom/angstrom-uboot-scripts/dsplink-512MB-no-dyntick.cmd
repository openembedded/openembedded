setenv vram '24M'
setenv dvimode 'hd720 mem=99M@0x80000000 mem=384M@0x88000000 omapfb.vram=0:12M,1:8M,2:4M nohz=off'
run loaduimage
run mmcboot
