PWD     := $(shell pwd)
SELECTION := CONFIG_MISDN_DRV=m CONFIG_MISDN_DSP=m CONFIG_MISDN_HFCUSB=m
default modules:
	$(MAKE) -C $(KDIR) SUBDIRS=${PWD}/drivers/isdn/hardware/mISDN/  EXTRA_CFLAGS=-I${PWD}/include modules ${SELECTION} 
