setenv memhole 'mem=453M@0x80000000 mem=512M@0xa0000000'
setenv dvimode 'omapfb.mode=dvi:1600x1200MR-24@60'
setenv hdmimode 'omapdss.hdmimode=0'
setenv fbvram 'omapfb.vram=0:16M,1:16M'
setenv vram 64M ${memhole} ${dvimode} ${fbvram}
run loaduimage
run mmcboot
