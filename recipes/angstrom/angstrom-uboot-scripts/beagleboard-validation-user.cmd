setenv console 'ttyS2,115200n8 console=tty0'
if test "${beaglerev}" = "AxBx"; then
setenv mpurate 600
setenv optargs 'mem=80M@0x80000000 musb_hdrc.fifomode=5'
elif test "${beaglerev}" = "Cx"; then
setenv mpurate 720
setenv optargs 'mem=80M@0x80000000 mem=128M@0x88000000 musb_hdrc.fifomode=5'
else
setenv mpurate 1000
setenv optargs 'mem=99M@0x80000000 mem=384M@0x88000000'
fi
run loaduimage
run loadramdisk
run ramboot

