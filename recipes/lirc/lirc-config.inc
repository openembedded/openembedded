EXTRA_OECONF = "--with-kerneldir=${STAGING_KERNEL_DIR} ${DRIVER}"

DRIVER ?= "--with-driver=serial --with-driver=mceusb"
# fails to build at the moment, re-enable later
#DRIVER_collie = "--with-driver=sa1100"
DRIVER_h3600 = "--with-driver=sa1100"
DRIVER_simpad = "--with-driver=sa1100"
DRIVER_nslu2 = "--with-driver=nslu2"
# XXX Why is X disabled on all these platforms anyway?
EXTRA_OECONF_append_collie = " --without-x"
EXTRA_OECONF_append_h3600 = " --without-x"
EXTRA_OECONF_append_simpad = " --without-x"
EXTRA_OECONF_append_nslu2 = " --without-x --with-transmitter --with-soft-carrier"
