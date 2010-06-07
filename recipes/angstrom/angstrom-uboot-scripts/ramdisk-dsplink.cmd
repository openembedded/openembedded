setenv bootargs 'console=tty0 console=ttyS2,115200n8 mpurate=1000 nohz=off vram=16M omapfb.mode=dvi:640x480MR-16@60 omapdss.def_disp=dvi omapfb.vram=0:8M,1:4M,2:4M root=/dev/ram0 rw rootfstype=ext2 initrd=0x81600000,32M ramdisk_size=32768 mem=99M@0x80000000 mem=384M@0x88000000'
fatload mmc 0 0x80200000 uImage
fatload mmc 0 0x81600000 ramdisk.gz
bootm 0x80200000
