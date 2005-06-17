SECTION = "x11/base"
PR = "r3"
LICENSE = "MIT"

SRC_URI = "cvs://anoncvs@dri.freedesktop.org/cvs/dri;module=drm;method=pserver \
	file://make.patch;patch=1"

inherit module-base

PV = "0.0cvs${CVSDATE}"
S = "${WORKDIR}/drm"

do_compile() {
        unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
	oe_runmake -C linux-core LINUXDIR="${KERNEL_SOURCE}" MAKE="make -e" CC="${KERNEL_CC}" LD="${KERNEL_LD}"
}

do_install() {
	install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/drm
	cd linux-core
	for i in *.ko; do install -m 0644 $i ${D}${base_libdir}/modules/${KERNEL_VERSION}/drm/; done
}

python populate_packages_prepend () {
	root = bb.data.expand('/lib/modules/${KERNEL_VERSION}/drm', d)

        do_split_packages(d, root, '^(.*)\.ko$',
			   output_pattern='drm-module-%s',
			   description='DRM driver module for %s',
			   extra_depends='')
}
