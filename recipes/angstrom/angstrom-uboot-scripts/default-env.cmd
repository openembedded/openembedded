setenv bootdelay 1
setenv loadaddr 0x82000000
setenv dvimode 'hd720'
setenv vram '12M'
setenv mem 'mem=99M@0x80000000 mem=128M@0x88000000'
setenv defaultdisplay 'dvi'
setenv loadbootscript 'fatload mmc 0 ${loadaddr} boot.scr'
setenv bootscript 'echo Running bootscript from mmc ...; source ${loadaddr}'
setenv loaduimage 'fatload mmc 0 ${loadaddr} uImage'
setenv mmcroot '/dev/mmcblk0p2 rw'
setenv mmcrootfstype 'ext3 rootwait
setenv mmcargs 'setenv bootargs console=${console} vram=${vram} omapfb.mode=dvi:${dvimode} omapdss.def_disp=${defaultdisplay} root=${mmcroot} rootfstype=${mmcrootfstype} ${mem}'
setenv mmcboot 'echo Booting from mmc ...; run mmcargs; bootm ${loadaddr}'
setenv nandroot '/dev/mtdblock4 rw'
setenv nandargs 'setenv bootargs console=${console} vram=${vram} omapfb.mode=dvi:${dvimode} omapfb.debug=y omapdss.def_disp=${defaultdisplay} root=${nandroot} rootfstype=${nandrootfstype}'
setenv nandboot 'echo Booting from nand ...; run nandargs; nand read ${loadaddr} 280000 400000; bootm ${loadaddr}'
setenv bootcmd 'if mmc init; then if run loadbootscript; then run bootscript; else if run loaduimage; then run mmcboot; else run nandboot; fi; fi; else run nandboot; if'
saveenv
boot
