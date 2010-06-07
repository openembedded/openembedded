#setenv usbtty 'cdc_acm'
#setenv mpurate '500'
#setenv buddy 'none'

#setenv vram '12M'
#setenv defaultdisplay 'dvi'
#setenv dvimode '640x480MR-16@60'

setenv setbase 'setenv baseargs ${memmap} console=${console} mpurate=${mpurate} buddy=${buddy} vram=${vram} musb_hdrc.fifomode=${musbfifomode} omapfb.mode=${defaultdisplay}:${dvimode} omapdss.def_disp=${defaultdisplay}'

setenv nandroot 'root=/dev/mtdblock4 rw rootfstype=jffs2'
setenv nandargs 'run setbase; setenv bootargs ${baseargs} ${nandroot}'
setenv nandloaduimage 'nand read ${loadaddr} 280000 400000'
setenv nandboot 'run nandloadimage; bootm ${loadaddr}'

setenv mmcroot 'root=/dev/mmcblk0p2 rw rootfstype=ext3 rootwait'
setenv mmcargs 'run setbase; setenv bootargs ${baseargs} ${mmcroot}'
setenv mmcloaduimage 'fatload mmc 0 ${loadaddr} uImage'
setenv mmcboot 'run mmcloaduimage; bootm ${loadaddr}'

echo Setting Specific Environment from MMC boot.scr

# set musb to only use 8k for fifo memory - not necesary on xm, but safe anyway
setenv musbfifomode '5'

# mpurate is read from omap registers on omap3530 (which x-load has set to 600mhz?), on xm, uboot sets this to 1GHz
#setenv mpurate '720'  
setenv memmap 'mem=80M mem=384M@0x88000000'
if "${beaglerev}" = "AxBx"; then
 setenv memmap 'mem=80M'
fi
if "${beaglerev}" = "Cx"; then
 setenv memmap 'mem=80M mem=128M@0x88000000'
fi
setenv vram '16M omapfb.vram=0:8M,1:4M,2:4M'
setenv defaultdisplay 'dvi'
setenv dvimode '640x480-32@60'

run mmcargs
printenv
run mmcboot

