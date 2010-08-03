setenv dvimode 'hd720'
setenv vram '16M omapfb.vram=0:8M,1:4M,2:4M'
if "${beaglerev}" = "AxBx"; then
setenv mpurate 600
setenv optargs 'mem=80M@0x80000000 musb_hdrc.fifomode=5'
elif "${beaglerev}" = "Cx"; then
setenv mpurate 720
setenv optargs 'mem=80M@0x80000000 mem=128M@0x88000000 musb_hdrc.fifomode=5'
else
setenv mpurate 1000
setenv optargs 'mem=80M@0x80000000 mem=384M@0x88000000'
fi
run loaduimage
run mmcboot

