#require linux-omap.inc

PV = "2.6.15-torfu"
PR = "r5"

COMPATIBLE_MACHINE = "(neuros-osd)"

#http://svn.neurostechnology.com/listing.php?repname=neuros-bsp&path=/branches/pqiu_rls_3.33-1.72_071207/kernels/linux-2.6.15/&rev=0&sc=0

SRC_URI = "svn://svn.neurostechnology.com/svn/neuros-bsp/branches/torfu/kernels;module=linux-2.6.15;proto=svn;rev= \
	file://g0-20080113.patch;patch=1\
	file://bsp_config.h \
	file://mtune-gcc4-fix.patch;patch=1 \ 
	file://defconfig"

S = "${WORKDIR}/linux-2.6.15"

inherit kernel

#KERNEL_CCSUFFIX = "-3.4.6"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
	install -m 0644 ${WORKDIR}/bsp_config.h ${S}/include/linux/bsp_config.h
}



