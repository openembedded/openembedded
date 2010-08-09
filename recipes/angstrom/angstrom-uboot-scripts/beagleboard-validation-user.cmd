mmc init
setenv rdaddr 0x81000000
setenv ramroot /dev/ram0
if test "${beaglerev}" = "AxBx"; then
setenv optargs mem=80M@0x80000000 musb_hdrc.fifomode=5
elif test "${beaglerev}" = "Cx"; then
setenv optargs mem=80M@0x80000000 mem=128M@0x88000000 musb_hdrc.fifomode=5
else
setenv optargs mem=80M@0x80000000 mem=384M@0x88000000
fi
run loadramdisk
run loaduimage
run ramboot

