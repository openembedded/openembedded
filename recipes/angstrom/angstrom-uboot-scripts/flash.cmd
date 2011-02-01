nand erase 260000 20000
mmcinit
mmc init
fatload mmc 0 82000000 MLO
nand unlock
nand ecc hw
nandecc hw
nand erase 0 80000
nand write 82000000 0 20000
nand write 82000000 20000 20000
nand write 82000000 40000 20000
nand write 82000000 60000 20000
fatload mmc 0 0x80200000 u-boot.bin
nand unlock
nand ecc sw
nandecc sw
nand erase 80000 160000
nand write 0x80200000 80000 160000
