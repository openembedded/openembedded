require orinoco-modules.inc

DEPENDS = "orinoco-conf spectrum-fw"
RDEPENDS += "orinoco-conf"
RDEPENDS_orinoco-modules-cs += "orinoco-modules spectrum-fw"
PR = "r8"

SRC_URI = "${SOURCEFORGE_MIRROR}/orinoco/orinoco-${PV}.tar.gz \
           file://makefile_fix.patch;patch=1 \
           file://list-move.patch;patch=1 \
           file://add_event.patch;patch=1 \
           file://add_utsname.patch;patch=1 \
           file://spectrum_cs_ids.patch;patch=1"

do_install() {
        install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/net/
        install -m 0644 *${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/net/
}

FILES_orinoco-modules-cs = "/lib/modules/${KERNEL_VERSION}/net/*_cs${KERNEL_OBJECT_SUFFIX}"
