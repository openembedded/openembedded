require orinoco-modules.inc

DEPENDS = "orinoco-conf spectrum-fw"
RDEPENDS += "orinoco-conf"
RDEPENDS_orinoco-modules-cs = "orinoco-modules spectrum-fw"
PR = "r3"

PARALLEL_MAKE = ""
EXTRA_OEMAKE = 'KERNEL_SRC="${KERNEL_STAGING_DIR}"'

# seems to cause problems on arm
DEFAULT_PREFERENCE_arm = "-1"

SRC_URI = "cvs://anonymous@cvs.sv.gnu.org/cvsroot/orinoco;module=orinoco;method=pserver \
           file://list-move.patch;patch=1"
S = "${WORKDIR}/orinoco"

do_install() {
	install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/net/
	install -m 0644 *${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/net/
}

FILES_orinoco-modules-cs = "/lib/modules/${KERNEL_VERSION}/net/*_cs${KERNEL_OBJECT_SUFFIX}"
