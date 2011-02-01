echo Erasing NAND

nand erase

mtdparts default

mmc init

echo Programming x-loader
fatload mmc 0 0x82000000 MLO
nandecc hw
nand erase 0 80000
nand write 82000000 0 20000
nand write 82000000 20000 20000
nand write 82000000 40000 20000
nand write 82000000 60000 20000

echo Programming u-boot
fatload mmc 0 0x82000000 u-boot.bin
nandecc sw
nand erase 80000 160000
nand write 0x82000000 80000 160000

echo Programming Linux
fatload mmc 0 0x82000000 uImage
nand erase 0x00280000 0x00400000
nand write 0x82000000 0x00280000 0x00400000

echo Programming rootfs
fatload mmc 0 0x82000000 rootfs.ubi
nand write.e 0x82000000 0x00680000 ${filesize}

echo Programming u-boot environment
setenv nandroot 'ubi0:beagleboard-rootfs ubi.mtd=4'
setenv nandrootfstype ubifs
saveenv

echo Please remove SD card and reboot
