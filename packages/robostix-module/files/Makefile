#############################################################################
#
#	Makefile for building the robostix module
#
#############################################################################

obj-m = robostix.o

PWD = $(shell pwd)
KBUILD_FLAGS = -C $(KERNEL_PATH) M=$(PWD) KERNELRELEASE=$(KERNELRELEASE)

default: modules

modules:
	$(MAKE) $(KBUILD_FLAGS) modules

clean:
	rm -rf *.o *~ *.ko *.mod.c

