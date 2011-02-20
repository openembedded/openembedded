require linux_${PV}.bb
require linux-openmoko.inc
# just for upgrade path in 2.6.34
KERNEL_RELEASE = "2.6.34.8"
OM-PR = "17"
PKGV = "${KERNEL_RELEASE}-oe${OM-PR}"
