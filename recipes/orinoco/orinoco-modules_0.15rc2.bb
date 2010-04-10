require orinoco-modules.inc

DEPENDS = "orinoco-conf spectrum-fw"
RDEPENDS += "orinoco-conf"
RDEPENDS_orinoco-modules-cs += "orinoco-modules spectrum-fw"
PR = "r10"

SRC_URI += "\
           file://makefile_fix.patch;patch=1 \
           file://list-move.patch;patch=1 \
           file://add_utsname.patch;patch=1 \
           file://add_event.patch;patch=1 \
           file://spectrum_cs_ids.patch;patch=1 \
           file://catch-up-with-kernel-changes.patch;patch=1"

do_install() {
        install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/net/
        install -m 0644 *${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/net/
}

FILES_orinoco-modules-cs = "/lib/modules/${KERNEL_VERSION}/net/*_cs${KERNEL_OBJECT_SUFFIX}"

SRC_URI[md5sum] = "2246f0879439d74f7aabc7935cec90c0"
SRC_URI[sha256sum] = "2997613ab33ad42dc8269a63b7c40a6938b3552e196780a4a269cc7340dd23bd"
