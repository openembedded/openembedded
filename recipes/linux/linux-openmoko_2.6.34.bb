require linux_${PV}.bb
require linux-openmoko.inc
# just for upgrade path in 2.6.34
KERNEL_RELEASE = "2.6.34.7"
OM-PR = "15"
PKGV = "${KERNEL_RELEASE}-oe${OM-PR}"
