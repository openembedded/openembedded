EXTRA_OECONF = "--with-kerneldir=${STAGING_KERNEL_DIR} ${DRIVER}"

PARALLEL_MAKE = ""

DRIVER ?= "--with-driver=serial --with-driver=mceusb"
# fails to build at the moment, re-enable later
#DRIVER_collie = "--with-driver=sa1100"
DRIVER_h3600 = "--with-driver=sa1100"
DRIVER_simpad = "--with-driver=sa1100"
DRIVER_nslu2 = "--with-driver=nslu2"
